import java.io.*;

class P1 {
    public static void main(String ar[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i;
        String a[][] = { { "", "START", "101", "" },
                { "", "MOVER", "BREG", "ONE" },
                { "AGAIN", "MULT", "BREG", "TERM" },
                { "", "MOVER", "CREG", "TERM" },
                { "", "ADD", "CREG", "N" },
                { "", "MOVEM", "CREG", "TERM" },
                { "N", "DS", "2", "" },
                { "RESULT", "DS", "2", "" },
                { "ONE", "DC", "1", "" },
                { "TERM", "DS", "1", "" },
                { "", "END", "", "" } };
        int lc = Integer.parseInt(a[0][2]);
        String st[][] = new String[5][2];
        int cnt = 0, l;

        // Additional tables for intermediate code generation
        String intermediateCode[][] = new String[10][4];
        String literalTable[][] = new String[5][2];
        String poolTable[][] = new String[5][2];
        int literalCount = 0, poolCount = 0;

        for (i = 0; i < 10; i++) {
            if (!a[i][0].equals("")) {
                // Symbol Table
                st[cnt][0] = a[i][0];
                st[cnt][1] = Integer.toString(lc);

                // Intermediate Code
                intermediateCode[cnt][0] = Integer.toString(lc);
                intermediateCode[cnt][1] = a[i][1];

                // Literal Table and Pool Table for DC statements
                if (a[i][1].equalsIgnoreCase("DC")) {
                    literalTable[literalCount][0] = a[i][3];
                    literalTable[literalCount][1] = Integer.toString(lc);
                    poolTable[poolCount][0] = Integer.toString(literalCount);
                    poolTable[poolCount][1] = a[i][3];
                    poolCount++;
                    literalCount++;
                }

                cnt++;

                if (a[i][1].equals("DS")) {
                    int d = Integer.parseInt(a[i][2]);
                    lc = lc + d;
                } else {
                    lc++;
                }
            } else {
                lc++;
            }
        }

        // Printing Symbol Table
        System.out.print("***SYMBOL TABLE****\n");
        System.out.println("_____________________");
        for (i = 0; i < cnt; i++) {
            for (int c = 0; c < 2; c++) {
                System.out.print(st[i][c] + "\t");
            }
            System.out.println();
        }

        // Printing Literal Table
        System.out.print("\n***LITERAL TABLE****\n");
        System.out.println("_____________________");
        for (i = 0; i < literalCount; i++) {
            for (int c = 0; c < 2; c++) {
                System.out.print(literalTable[i][c] + "\t");
            }
            System.out.println();
        }

        // Printing Pool Table
        System.out.print("\n***POOL TABLE****\n");
        System.out.println("_____________________");
        for (i = 0; i < poolCount; i++) {
            for (int c = 0; c < 2; c++) {
                System.out.print(poolTable[i][c] + "\t");
            }
            System.out.println();
        }

        // Printing Intermediate Code
        System.out.println("\n *****INTERMEDIATE CODE*****\n");
        System.out.println("LC\tOPCODE\tOPERAND\tRESULT");
        for (i = 0; i < cnt; i++) {
            for (int c = 0; c < 4; c++) {
                System.out.print(intermediateCode[i][c] + "\t");
            }
            System.out.println();
        }
    }
}
