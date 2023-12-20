import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
*
* BDShape[9][11] de Forme= [     [f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11]
                                 [f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11]
                                 [f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11]
                                 [f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11]
                                 [f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11]
                                 [f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11]
                                 [f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11]
                                 [f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11]
                                 [f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11]      ]

                        * Où chaque ligne represente une classe de formes
                        * Chaque colonne represente des echantillons
                        * BDShape [5][8] Represente l'echantillon 9 de la classe 6
        Forme {
              E34= <25, 2, 5, 6, 8, ....., 5>
              GFD= <25, 2, 5, 6, 8, ....., 5>
              SA= <25, 2, 5, 6, 8, ....., 5>
              F0= <25, 2, 5, 6, 8, ....., 5>
                };
* */



public class Criteres {

        //Tableau BDShape
        Shape[][] BdShape = new Shape[9][11];


        List<Double> E34 = new ArrayList<>();
        List<Double> GFD = new ArrayList<>();
        List<Double> SA = new ArrayList<>();
        List<Double> F0 = new ArrayList<>();



        public Criteres() {

            //Selon Methode
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 12; j++) {
                    String fileName = "src/E34/s0"+i+"n0"+String.format("%02d", j)+".E34";
                    File file = new File(fileName);
                    ArrayList<Double> lign=new ArrayList<>();
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            //lire le fichier ligne par ligne
                            String line = scanner.nextLine();
                            try {
                                //remplir la liste value avec les valeurs de lignes
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
                        System.err.println("Fichier non trouvé: " + fileName);
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
                            //lire le fichier ligne par ligne
                            String line = scanner.nextLine();
                            try {
                                //remplir la liste value avec les valeurs de lignes
                                Double value = Double.parseDouble(line.trim());
                                this.GFD.add(value);
                                lign.add(value);

                            } catch (NumberFormatException e) {
                                System.err.println("Ligne non valide trouvée et ignorée: " + line);
                            }
                        } this.BdShape[i-1][j-1].GFD=lign;
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.err.println("Fichier non trouvé: " + fileName);
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
                            //lire le fichier ligne par ligne
                            String line = scanner.nextLine();
                            try {
                                //remplir la liste value avec les valeurs de lignes
                                Double value = Double.parseDouble(line.trim());
                                this.SA.add(value);
                                lign.add(value);
                            } catch (NumberFormatException e) {
                                System.err.println("Ligne non valide trouvée et ignorée: " + line);
                            }
                        } this.BdShape[i-1][j-1].SA=lign;
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.err.println("Fichier non trouvé: " + fileName);
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
                            //lire le fichier ligne par ligne
                            String line = scanner.nextLine();
                            try {
                                //remplir la liste value avec les valeurs de lignes
                                Double value = Double.parseDouble(line.trim());
                                this.F0.add(value);
                                lign.add(value);
                            } catch (NumberFormatException e) {
                                System.err.println("Ligne non valide trouvée et ignorée: " + line);
                            }
                        }this.BdShape[i-1][j-1].F0=lign;
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.err.println("Fichier non trouvé: " + fileName);
                    }

                }
            }


        }

        //Calculer la matrice de confusion
        public Double[][] Mat_confus(Shape[][] bdshape){
            Double[][] mat_con = new Double[9][9];
            //initialiser une matrice 9*9 de zeros
            for(int i=0; i<9;i++){
                for(int j=0; j<9;j++) {
                    mat_con[i][j]=0.0;}}

            //comparer
            for(int i=0; i<9;i++){
                for(int j=0; j<11;j++){

                    if(bdshape[i][j].getCluster()==i){ mat_con[i][i]+=1;}

                    else{ mat_con[i][bdshape[i][j].getCluster()]+=1;}
                }
            }

            return mat_con;
        }


    }

