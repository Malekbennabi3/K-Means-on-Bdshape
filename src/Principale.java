import java.util.Random;
import java.util.Scanner;

public class Principale {

    // Specify the number of clusters (k)
    static int k = 9;

    //By default p=2 is the norm for the Euclidean distance
    static int p;

    //Choose random norm for the Minkowski's distance
    static Random rand = new Random();
    static int[] p_norme = {1, 2, (3 + rand.nextInt(10))};



       static String[] methode = {"E34", "GFD", "SA", "F0"};
       static String[] distance = {"Manhatten", "Euclidean", "Minkowski with norm_"+p_norme[2]};


        public static void main(String[] args) {

        Criteres c1 = new Criteres();
        Shape[][] t_bdshape = c1.BdShape;
        Scanner sc = new Scanner(System.in);


            System.out.print("\n Specify the number of clusters 'k' in K-Means Algorithm: k=");
            // Specify the number of clusters (k)
            k=sc.nextInt();

            System.out.print("\n Specify the number of iterations for the K-Means Algorithm: ");
            // Specify the number of iterations
            int n_it=sc.nextInt();


            //Array for every feature's execution time
             double[] t_ex_e34 = new double[n_it];
             double[] t_ex_gfd = new double[n_it];
             double[] t_ex_sa  = new double[n_it];
             double[] t_ex_f0  = new double[n_it];

            //Array for every feature's global precision
             double[] p_ex_e34 = new double[n_it];
             double[] p_ex_gfd = new double[n_it];
             double[] p_ex_sa  = new double[n_it];
             double[] p_ex_f0  = new double[n_it];

            //Array for every feature's repeal
            double[] r_ex_e34 = new double[n_it];
            double[] r_ex_gfd = new double[n_it];
            double[] r_ex_sa  = new double[n_it];
            double[] r_ex_f0  = new double[n_it];

            //Array for every feature's true positives
            double[] po_ex_e34 = new double[n_it];
            double[] po_ex_gfd = new double[n_it];
            double[] po_ex_sa  = new double[n_it];
            double[] po_ex_f0  = new double[n_it];




            for (int p=1; p<4; p++) {

            //Test for the 4 features
            for (int m = 0; m < 4; m++) {

                String s = methode[m];

                for (int it = 0; it < n_it; it++) {

                    // Create KMeansClustering instance and perform clustering
                    KMeans kMeans = new KMeans(t_bdshape, k);


                    //Calculate the execution time
                    // start time
                    long startTime = System.nanoTime();

                    // Call the method you want to measure the execution time of
                    kMeans.cluster(s, p);

                    // end time
                    long endTime = System.nanoTime();

                    // Calculate the execution time in milliseconds
                    long executionTime = (endTime - startTime) / 1000000;

                    // execution time
                    System.out.println("The execution time of the feature " + s + " is: " + executionTime + " ms. || " + (endTime - startTime) + " ns");

                    switch (m) {
                        case 0:
                            t_ex_e34[it] = (double) (endTime - startTime) / 1000000;
                            break;
                        case 1:
                            t_ex_gfd[it] = (double) (endTime - startTime) / 1000000;
                            break;
                        case 2:
                            t_ex_sa[it] = (double) (endTime - startTime) / 1000000;
                            break;
                        case 3:
                            t_ex_f0[it] = (double) (endTime - startTime) / 1000000;
                            break;
                    }

                    //Displaying the new Clusters
                    for (int c = 0; c < k; c++) {
                        int nb_c = 0;
                        System.out.println("Cluster " + c + ":");

                        //Browse into BDShape array
                        for (int i = 0; i < t_bdshape.length; i++) {
                            for (int j = 0; j < t_bdshape[0].length; j++) {

                                //Display the all shapes of a Cluster c
                                if (t_bdshape[i][j].getCluster() == c) {

                                    System.out.println("(" + t_bdshape[i][j].getE34() + "\n\n, " + t_bdshape[i][j].getGFD() + "\n\n, "
                                            + t_bdshape[i][j].getSA() + "\n, " + t_bdshape[i][j].getF0() + ")");
                                    nb_c++;
                                }
                            }
                        }
                        System.out.println(); // Empty line for separation
                        System.out.println("Cluster " + c + " Contains " + nb_c + " Elements.");
                        System.out.println("_____________________________________________________________________________________________________________________");
                    }

                    System.out.println(kMeans.centroids);


                    //Precision
                    Double[] prec = new Double[k];

                    //Recall
                    Double[] rapp = new Double[k];

                    //Display confusion matrix
                    Double[][] mat = c1.Mat_confus(t_bdshape);
                    int vp = 0;
                    int vn = 0;
                    int nb = 0;
                    double nb_c;
                    double pt = 0, rt = 0;

                    System.out.println("Confusion Matrix: ");
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {

                            //line by line Display
                            System.out.print("   " + mat[i][j]);

                            //True negatives
                            if (j != i) vn += mat[i][j];

                            //Number of elements by column
                            nb += mat[j][i];


                        }
                        //Number of correct predictions
                        nb_c = mat[i][i];

                        //Precision (Nb_Correct/Nb_total)
                        prec[i] = nb_c / nb;

                        //Repeal
                        rapp[i] = nb_c / 11;

                        nb = 0;

                        //True positives
                        vp += mat[i][i];
                        System.out.println();
                    }
                    System.out.println("\n True positives: " + vp + "\n True Negatives: " + vn);

                    for (int i = 0; i < 9; i++) {
                        System.out.print("\n\n Precision of the class " + i + " is: ");
                        System.out.printf("%.3f", prec[i]);

                        System.out.print("\n Repeal of the class " + i + " is: ");
                        System.out.printf("%.3f", rapp[i]);
                        pt += prec[i];
                        rt += rapp[i];
                    }
                    System.out.printf("\n\n %s%.3f", "Total Precison: ", (pt / 9));
                    System.out.printf("\n %s%.3f", "Total Repeal : ", (rt / 9));

                    //Collect the precision data of every feature
                    switch (m) {
                        case 0:
                            p_ex_e34[it] = (double) (pt / 9) * 100;
                            r_ex_e34[it] = (double) (rt / 9) * 100;
                            po_ex_e34[it] = vp;

                            break;
                        case 1:
                            p_ex_gfd[it] = (double) (pt / 9) * 100;
                            r_ex_gfd[it] = (double) (rt / 9) * 100;
                            po_ex_gfd[it] = vp;

                            break;
                        case 2:
                            p_ex_sa[it] = (double) (pt / 9) * 100;
                            r_ex_sa[it] = (double) (rt / 9) * 100;
                            po_ex_sa[it] = vp;

                            break;
                        case 3:
                            p_ex_f0[it] = (double) (pt / 9) * 100;
                            r_ex_f0[it] = (double) (rt / 9) * 100;
                            po_ex_f0[it] = vp;

                            break;
                    }

                }
            }

 /* Optional display
            System.out.println("\n E34 execution time:");
            for (int n = 0; n < n_it; n++)
                System.out.println(t_ex_e34[n]);

            System.out.println("\n GFD execution time:");
            for (int n = 0; n < n_it; n++)
                System.out.println(t_ex_gfd[n]);

            System.out.println("\n SA execution time:");
            for (int n = 0; n < n_it; n++)
                System.out.println(t_ex_sa[n]);

            System.out.println("\n F0 execution time:");
            for (int n = 0; n < n_it; n++)
                System.out.println(t_ex_f0[n]);
*/

            //Graphics representation
            Hist.Histo_car(distance[p-1], "Execution Time (ms)", t_ex_e34, t_ex_gfd, t_ex_sa, t_ex_f0);
            Hist.Histo_prec(distance[p-1],"Precision (%)", p_ex_e34, p_ex_gfd, p_ex_sa, p_ex_f0);
            Hist.Histo_rapp(distance[p-1],"Repeal (%)", r_ex_e34, r_ex_gfd, r_ex_sa, r_ex_f0);
            Hist.courb_pos(distance[p-1],"True Positives", po_ex_e34, po_ex_gfd, po_ex_sa, po_ex_f0);

        }
    }

}
