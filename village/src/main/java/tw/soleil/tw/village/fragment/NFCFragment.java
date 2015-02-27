/*
 * Copyright (c) 2015. Soleil Studio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package tw.soleil.tw.village.fragment;

import android.annotation.TargetApi;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Locale;

import tw.soleil.tw.village.R;
import tw.soleil.tw.village.Village;
import tw.soleil.tw.village.service.CreateRecordService;

/**
 * Created by edward_chiang on 15/2/7.
 */
public class NFCFragment extends PlaceholderFragment implements
        NfcAdapter.CreateNdefMessageCallback,
        NfcAdapter.OnNdefPushCompleteCallback {

    private NfcAdapter nfcAdapter;

    private TextView nfcTextView;

    private static final int MESSAGE_SENT = 1;

    public static NFCFragment newInstance(int sectionNumber) {
        NFCFragment fragment = new NFCFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nfc_display, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nfcTextView = (TextView)view.findViewById(R.id.nfc_text_view);

        nfcAdapter = NfcAdapter.getDefaultAdapter(getActivity());
        if (nfcAdapter == null) {
            nfcTextView.setText("NFC is not available on this device.");
        } else {
            nfcAdapter.setNdefPushMessageCallback(NFCFragment.this, getActivity());
            nfcAdapter.setOnNdefPushCompleteCallback(NFCFragment.this, getActivity());
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if  (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getActivity().getIntent().getAction())) {
            Parcelable[] rawMessages = getActivity().getIntent().getParcelableArrayExtra(
                    NfcAdapter.EXTRA_NDEF_MESSAGES);

            if  (rawMessages.length >= 1) {
                String message = getNDEFMessage(rawMessages);
                nfcTextView.setText(message);
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public NdefMessage createNdefMessage(NfcEvent event) {
        Log.d(Village.TAG, " Event: " + event);
        String text = ("Beam me up, Android! " +
                "Beam Time: " + System.currentTimeMillis());
        NdefMessage msg = new NdefMessage(
                new NdefRecord[] {CreateRecordService.createNewTextRecord(text, Locale.getDefault(), true)});

        return msg;
    }

    @Override
    public void onNdefPushComplete(NfcEvent event) {
        beamHandler.obtainMessage(MESSAGE_SENT).sendToTarget();
    }

    private final Handler beamHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_SENT:
                    Toast.makeText(getActivity(), "Message sent!", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    private String getNDEFMessage(Parcelable[] rawMessages) {
        String message = new String();
        for (int i = 0; i < rawMessages.length; i++) {
            NdefRecord[] recs = ((NdefMessage) rawMessages[i]).getRecords();
            for (int j = 0; j < recs.length; j++) {
                if (recs[j].getTnf() == NdefRecord.TNF_WELL_KNOWN &&
                        Arrays.equals(recs[j].getType(), NdefRecord.RTD_TEXT)) {
                    byte[] payload = recs[j].getPayload();
                    String textEncoding = ((payload[0] & 0200) == 0) ? "UTF-8" : "UTF-16";
                    int langCodeLen = payload[0] & 0077;

                    try {
                        message += ("NdefMessage[" + i + "], NdefRecord[" + j + "]:\n\"" +
                                new String(payload, langCodeLen + 1,
                                        payload.length - langCodeLen - 1, textEncoding) +"\"");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        Log.e(Village.TAG, "Error: " + e.getLocalizedMessage());
                    }
                }
            }
        }
        return message;
    }
}
