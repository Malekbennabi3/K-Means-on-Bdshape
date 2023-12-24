import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
*
* BDShape[9][11] of Shape= [     [s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11]
                                 [s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11]
                                 [s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11]
                                 [s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11]
                                 [s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11]
                                 [s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11]
                                 [s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11]
                                 [s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11]
                                 [s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11]      ]

                        * Every row represents a class of Shape
                        * Every column represents a shape of the class[row]
                        * BDShape [5][8] Represents the 9th shape of the class 6
        Shape {
              E34= <25, 2, 5, 6, 8, ....., 5>
              GFD= <25, 2, 5, 6, 8, ....., 5>
              SA= <25, 2, 5, 6, 8, ....., 5>
              F0= <25, 2, 5, 6, 8, ....., 5>
                };
* */



public class Criteres {

        // BDShape's Array [Class][Sample].
        Shape[][] BdShape = new Shape[9][11];

      //List for every feature
        List<Double> E34 = new ArrayList<>();
        List<Double> GFD = new ArrayList<>();
        List<Double> SA = new ArrayList<>();
        List<Double> F0 = new ArrayList<>();



        public Criteres() {

            //Read every feature's file and convert it into a feature's List for every shape[i][j]
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 12; j++) {
                    String fileName = "src/E34/s0"+i+"n0"+String.format("%02d", j)+".E34";
                    File file = new File(fileName);
                    ArrayList<Double> lign=new ArrayList<>();
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            //Read the file line by line
                            String line = scanner.nextLine();
                            try {
                            Double value = Double.parseDouble(line.trim());
                                this.E34.add(value);
                                lign.add(value);
                                //this.BdShape[i-1][j-1]=new Forme(E34,null,null,null);

                            } catch (NumberFormatException e) {
                                System.err.println("Ligne non valide trouvée et ignorée: " + line);
                            }
                        }
                        this.BdShape[i-1][j-1]=new Shape(lign,null,null,null);

                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.err.println("File not Found: " + fileName);
                    }

                }
            }
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 12; j++) {
                    String fileName = "src/GFD/s0"+i+"n0"+String.format("%02d", j)+".GFD";
                    File file = new File(fileName);

                    ArrayList<Double> lign=new ArrayList();

                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            //read the file line by line
                            String line = scanner.nextLine();
                            try {
                                Double value = Double.parseDouble(line.trim());
                                this.GFD.add(value);
                                lign.add(value);

                            } catch (NumberFormatException e) {
                                System.err.println("Line not found : " + line);
                            }
                        } this.BdShape[i-1][j-1].GFD=lign;
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.err.println("File not Found: " + fileName);
                    }

                }
            }
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 12; j++) {
                    String fileName = "src/SA/s0"+i+"n0"+String.format("%02d", j)+".SA";
                    File file = new File(fileName);
                    ArrayList lign=new ArrayList();
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            //read the file line by line
                            String line = scanner.nextLine();
                            try {
                                Double value = Double.parseDouble(line.trim());
                                this.SA.add(value);
                                lign.add(value);
                            } catch (NumberFormatException e) {
                                System.err.println("Line not found: " + line);
                            }
                        } this.BdShape[i-1][j-1].SA=lign;
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.err.println("File not found: " + fileName);
                    }

                }
            }
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 12; j++) {
                    String fileName = "src/F0/s0"+i+"n0"+String.format("%02d", j)+".F0";
                    File file = new File(fileName);
                    ArrayList lign=new ArrayList();
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            //read the file line by line
                            String line = scanner.nextLine();
                            try {
                                Double value = Double.parseDouble(line.trim());
                                this.F0.add(value);
                                lign.add(value);
                            } catch (NumberFormatException e) {
                                System.err.println("Line not found: " + line);
                            }
                        }this.BdShape[i-1][j-1].F0=lign;
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.err.println("File not found: " + fileName);
                    }

                }
            }


        }

        //Calculate the confusion matrix
        public Double[][] Mat_confus(Shape[][] bdshape){
            Double[][] mat_con = new Double[9][9];
            //initialization of (9*9) zeros Matrix
            for(int i=0; i<9;i++){
                for(int j=0; j<9;j++) {
                    mat_con[i][j]=0.0;}}

            //compare
            for(int i=0; i<9;i++){
                for(int j=0; j<11;j++){

                    if(bdshape[i][j].getCluster()==i){ mat_con[i][i]+=1;}

                    else{ mat_con[i][bdshape[i][j].getCluster()]+=1;}
                }
            }

            return mat_con;
        }


    }

