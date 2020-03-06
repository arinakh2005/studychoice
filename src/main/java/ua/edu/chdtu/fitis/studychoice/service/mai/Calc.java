package ua.edu.chdtu.fitis.studychoice.service.mai;

import static java.lang.Math.abs;
import static java.lang.System.*;

public class Calc {
    float[] U = new float[]{1.2f, 1, 1.3f, 1.4f, 1.5f, 1.1f, 1.6f, 1.7f, 1, 1.5f};
    int[] UN = new int[10];
    float[] A = new float[9], B = new float[9];
    float[][] AA = new float[10][10];
    float Umax;
    float Umin;
    float h, d;

    public static void main(String[] args) {
        new Calc();
    }

    public Calc() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i == 0) {
                    Umax = U[0];
                    Umin = U[0];
                } else if (Umax < U[i]) {
                    Umax = U[i];
                } else if (Umin > U[i]) {
                    Umin = U[i];
                }
            }
            out.println("Umax="+ Umax);
            out.println("Umin=" + Umin);
        } catch (Exception e) {
        }
        try {
            h = (Umax - Umin) / 9;
            out.println("h=" + h);
            A[0]=Umin;
            B[0]= A[0] + h;
            out.println("[" + A[0] + "," + B[0]);
            for (int i = 1; i < 9; i++) {
                A[i] = B[i-1] + 0.01f;
                B[i] = A[i] + h - 0.01f;
                out.println("[" + A[i] + "," + B[i] + "]");
            }
            for (int i=0; i<10; i++) {
                for (int j = 0; j < 9; j++) {
                    if (U[i]>=A[j] && U[i]<=B[j]) {
                        UN[i]=j + 1;
                        out.println("UN[" + i + "]=" + UN[i]);
                        break;
                    }
                }
            }
            for (int i=0; i<10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (i==j) {
                        AA [i][j] = 1;
                    } else {
                        d = UN[i]-UN[j];
                        if (d>=0){
                            AA[i][j] = d+1;
                        }else {
                            AA[i][j] = 1/(abs(d)+1);
                        }
                    }
                    out.println("AA[" + i + "," + j + "]=" + AA[i][j]);
                }
            }
        } catch (Exception e) {
        }
    }
}


