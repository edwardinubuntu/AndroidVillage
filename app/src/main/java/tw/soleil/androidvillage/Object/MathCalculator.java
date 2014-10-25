/*
 * Copyright (c) 2014. Soleil Studio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package tw.soleil.androidvillage.Object;

/**
 * Created by edward_chiang on 14/10/25.
 */
public class MathCalculator {

    private double originalNumber;

    private Operation operation;

    private double comingNumber;

    public enum Operation {
        ADD, Subtract, Multiple, Divide
    }

    public double getOriginalNumber() {
        return originalNumber;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
        this.moveAndSaveNumber();
        this.clearComingNumber();
    }

    public double getAnswer () {
        return this.originalNumber;
    }

    public double getComingNumber() {
        return comingNumber;
    }

    public void setComingNumber(double comingNumber) {
        this.comingNumber = this.comingNumber * 10 + comingNumber;
    }

    public void moveAndSaveNumber() {
        this.originalNumber = this.comingNumber;
    }

    public void clearComingNumber () {
        this.comingNumber = 0;
    }

    public void clearAll() {
        this.originalNumber = 0;
        this.comingNumber = 0;
        this.operation = null;
    }

    public void operate() {
        switch (this.operation) {
            case ADD:
                this.originalNumber = this.originalNumber + this.comingNumber;
                break;
            case Subtract:
                this.originalNumber = this.originalNumber - this.comingNumber;
                break;
            case Multiple:
                this.originalNumber = this.originalNumber * this.comingNumber;
                break;
            case Divide:
                this.originalNumber = this.originalNumber / this.comingNumber;
                break;

            default:
        }
    }
}
