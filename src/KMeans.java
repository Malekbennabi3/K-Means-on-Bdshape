import java.util.ArrayList;
import java.util.Random;


public class KMeans {

    //Array of shapes BDShape
    public Shape[][] t_bdshape;
    // Number of clusters
    public int k;
    //List of shapes (Cluster's center)
    public ArrayList<Shape> centroids;

    //Constructor of the Class KMeans
    public KMeans(Shape[][] t_bdshape, int k) {
        this.t_bdshape = t_bdshape;
        this.k = k;
        centroids = initialiser_Centroids();
    }

    // 2- Initialization of random centroids
    public ArrayList<Shape> initialiser_Centroids() {
        Random rand = new Random();
        ArrayList<Shape> centroids = new ArrayList<>();

        //Selectionner une forme au hasard pour chaque Classe
        for (int i = 0; i < k; i++) {
            // un entier au hasard de 0 - 11 (qui correspondra au nombre de l'echantillon)
            int randomIndex = rand.nextInt(11);    //(t_dataPoints1[0].length);
            //Ajouter la forme choisit au hasard a la liste initiales des centroids
            centroids.add(t_bdshape[i][randomIndex]);
        }
        //Liste des Centres de classes choisies
        //this.centroids=centroids;
        return centroids;
    }


    // 3- Assigne every shape to its close centroid's center
    public void assigner_Clusters(String s, int p) {
        switch (s) {
            case "E34":
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 11; j++) {

                        //On assigne la valeur  +(Infini) a la variable Distance minimale
                        double minDistance = Double.MAX_VALUE;
                        double distance;
                        int clusterIndex = -1;
                        //for (int t = 0; t < k; t++) {
                        for (int t = 0; t < k; t++) {

                            // (À Appliquer sur tous les caracteristiques (Listes E34, GFD, SA, F0) )
                            //Calculer la distance entre le point actuel et tous les centres

                            // puis assigner le point actuel aux centre le plus proche(Avec la petite distance)
                            distance = calculateDistance(t_bdshape[i][j].E34, centroids.get(t).getE34(), p);


                            if (distance < minDistance) {
                                minDistance = distance;
                                clusterIndex = t;

                                //inert_e34[t]+=distance;
                            }
                        }
                        // Assigner la Forme au plus proche centre
                        t_bdshape[i][j].setCluster(clusterIndex);
                    }
                }
                break;
            case "GFD":
                for (int i = 0; i < 9; i++){
                    for (int j = 0; j < 11; j++){

                        //On assigne la valeur  +(Infini) a la variable Distance minimale
                        double minDistance = Double.MAX_VALUE;
                        double distance;
                        int clusterIndex = -1;
                        //for (int t = 0; t < k; t++) {
                        for (int t = 0; t < k; t++) {

                            // (À Appliquer sur tous les caracteristiques (Listes E34, GFD, SA, F0) )
                            //Calculer la distance entre le point actuel et tous les centres

                            // puis assigner le point actuel aux centre le plus proche(Avec la petite distance)
                            distance = calculateDistance(t_bdshape[i][j].GFD, centroids.get(t).getGFD(), p);

                            //inert_gfd[t]+=distance;

                            if (distance < minDistance) {
                                minDistance = distance;
                                clusterIndex = t;
                            }
                        }
                        // Assigner la Forme au plus proche centre
                        t_bdshape[i][j].setCluster(clusterIndex);
                    }
                }
                break;
            case "SA":
                for (int i = 0; i < 9; i++){
                    for (int j = 0; j < 11; j++){

                        //On assigne la valeur  +(Infini) a la variable Distance minimale
                        double minDistance = Double.MAX_VALUE;
                        double distance;
                        int clusterIndex = -1;
                        //for (int t = 0; t < k; t++) {
                        for (int t = 0; t < k; t++) {

                            // (À Appliquer sur tous les caracteristiques (Listes E34, GFD, SA, F0) )
                            //Calculer la distance entre le point actuel et tous les centres

                            // puis assigner le point actuel aux centre le plus proche(Avec la petite distance)
                            distance = calculateDistance(t_bdshape[i][j].SA, centroids.get(t).getSA(), p);

                            //inert_sa[t]+=distance;


                            if (distance < minDistance) {
                                minDistance = distance;
                                clusterIndex = t;
                            }
                        }
                        // Assigner la Forme au plus proche centre
                        t_bdshape[i][j].setCluster(clusterIndex);
                    }
                }
                break;
            case "F0":
                for (int i = 0; i < 9; i++){
                    for (int j = 0; j < 11; j++){

                        //On assigne la valeur  +(Infini) a la variable Distance minimale
                        double minDistance = Double.MAX_VALUE;
                        double distance;
                        int clusterIndex = -1;
                        //for (int t = 0; t < k; t++) {
                        for (int t = 0; t < k; t++) {

                            // (À Appliquer sur tous les caracteristiques (Listes E34, GFD, SA, F0) )
                            //Calculer la distance entre le point actuel et tous les centres

                            // puis assigner le point actuel aux centre le plus proche(Avec la petite distance)
                            distance = calculateDistance(t_bdshape[i][j].F0, centroids.get(t).getF0(), p);

                            //inert_f0[t]+=distance;


                            if (distance < minDistance) {
                                minDistance = distance;
                                clusterIndex = t;
                            }
                        }
                        // Assigner la Forme au plus proche centre
                        t_bdshape[i][j].setCluster(clusterIndex);
                    }
                }
                break;
        }
    }

    //4- Calculate the new Centroid by testing the mean of every Cluster
    private void ajuster_Centroids(String s) {

        //List of new centers
        ArrayList<Shape> newCentroids = new ArrayList<>();

        switch (s) {
            case "E34":
                //List to calculate every features mean
                ArrayList<Double> totalE34 = new ArrayList<>();

                //initialize the List with zeros
                for (int i = 0; i < t_bdshape[0][0].E34.size(); i++) {
                    totalE34.add(0.0);
                }

                //Browse all centroid's elements
                for (int z = 0; z < k; z++) {

                    //Browse all E34 feature's elements (16 elements)
                    int count = 0;
                    //Browse shape's array
                    for (int i = 0; i < t_bdshape.length; i++) {
                        for (int j = 0; j < t_bdshape[0].length; j++) {

                            //if the actual shape is in the same cluster
                            if (t_bdshape[i][j].getCluster() == z) {

                                //TotalE34[j] +=Forme[i][j].E34[j]
                                for (int it = 0; it < totalE34.size(); it++) {
                                    totalE34.set(it, totalE34.get(it) + t_bdshape[i][j].E34.get(it));
                                    count++;
                                }
                            }
                        }
                    }
                    if (count > 0) {
                        for (int i = 0; i < totalE34.size(); i++) {
                            //Assign the mean to the same position ( Sum(total[i])/ nb_total)
                            totalE34.set(i, totalE34.get(i) / count);
                        }
                        newCentroids.add(new Shape(totalE34, null, null, null));
                    }

                }
                //The centroid receive the new centers
                this.centroids = newCentroids;
                totalE34.clear();
                break;
            case "GFD":
                //List to calculate the GFD feature's mean
                ArrayList<Double>  totalGFD= new ArrayList<>();

                //initialize the List with zeros
                for(int i = 0; i< t_bdshape[0][0].GFD.size(); i++){ totalGFD.add(0.0);}

                //Browse all the centroid's elements
                for (int z = 0; z < k; z++) {

                    //Browse all GFD feature's elements (100 elements)
                    int count = 0;
                    //Browse shape's array
                    for (int i = 0; i < t_bdshape.length; i++) {
                        for(int j = 0; j < t_bdshape[0].length; j++) {

                            //if the actual shape is in the same cluster
                            if (t_bdshape[i][j].getCluster() == z) {


                                //TotalE34[j] +=Forme[i][j].E34[j]
                                for(int it=0; it< totalGFD.size(); it++){
                                    totalGFD.set(it, totalGFD.get(it) + t_bdshape[i][j].GFD.get(it));
                                    count++; }}
                        } }
                    if(count>0){
                        for(int i=0;i<totalGFD.size();i++) {
                            //Assigner la moyenne des valeurs dans la meme position ( Somme(total[i])/ nombre_total)
                            totalGFD.set(i, totalGFD.get(i)/count);}
                        newCentroids.add(new Shape(null, totalGFD,null,null)); }
                }
                //Le centroid reçois les nouveaux centres
                this.centroids = newCentroids;
                totalGFD.clear();
                break;

            case "SA":
                //List to calculate the SA feature's mean
                ArrayList<Double>  totalSA = new ArrayList<>();

                //initialize the List with zeros
                for(int i = 0; i< t_bdshape[0][0].SA.size(); i++){ totalSA.add(0.0);}

                //Browse all the centroid's elements
                for (int z = 0; z < k; z++) {

                    //Browse all SA feature's elements (90 elements)
                    int count = 0;
                    //Browse shape's array
                    for (int i = 0; i < t_bdshape.length; i++) {
                        for(int j = 0; j < t_bdshape[0].length; j++) {

                            //if the actual shape is in the same cluster
                            if (t_bdshape[i][j].getCluster() == z) {


                                //TotalE34[j] +=Forme[i][j].E34[j]
                                for(int it=0; it< totalSA.size(); it++){
                                    totalSA.set(it, totalSA.get(it) + t_bdshape[i][j].SA.get(it));
                                    count++; }}
                        } }
                    if(count>0){
                        for(int i=0;i<totalSA.size();i++) {
                            //Assign the mean to the same position ( Sum(total[i])/ nb_total)
                            totalSA.set(i, totalSA.get(i)/count);}
                        newCentroids.add(new Shape(null, null,totalSA,null)); }
                }
                //the centroid receive the new centers
                this.centroids = newCentroids;
                totalSA.clear();

                break;

            case "F0":
                //List to calculate the F0 feature's mean
                ArrayList<Double>  totalF0 = new ArrayList<>();

                //initialize the List with zeros
                for(int i = 0; i< t_bdshape[0][0].F0.size(); i++){ totalF0.add(0.0);}

                //Browse all the centroid's elements
                for (int z = 0; z < k; z++) {

                    //Browse all F0 feature's elements (128 elements)
                    int count = 0;
                    //Browse shape's array
                    for (int i = 0; i < t_bdshape.length; i++) {
                        for(int j = 0; j < t_bdshape[0].length; j++) {

                            //if the actual shape is in the same cluster
                            if (t_bdshape[i][j].getCluster() == z) {


                                //TotalE34[j] +=Forme[i][j].E34[j]
                                for(int it=0; it< totalF0.size(); it++){
                                    totalF0.set(it, totalF0.get(it) + t_bdshape[i][j].F0.get(it));
                                    count++; }}
                        } }
                    if(count>0){
                        for(int i=0;i<totalF0.size();i++) {
                            //Assign the mean to the same position ( Sum(total[i])/ nb_total)
                            totalF0.set(i, totalF0.get(i)/count);}
                        newCentroids.add(new Shape(null, null,null,totalF0)); }
                }
                //The centroid receive the new centers
                this.centroids = newCentroids;
                totalF0.clear();
                break;

        }
    }

    // Calculer the p-distance of two features (E34, GFD, SA, F0)
    public static double calculateDistance(ArrayList<Double> a, ArrayList<Double> b, int p) {
        double s=0.0;
        for(int i=0; i<b.size(); i++){
            s+= Math.pow(Math.abs(a.get(i)- b.get(i)), p);
        }
        return Math.pow(s, (double)(1.0/p) );
    }

    //K-means clustering
    public void cluster(String s, int p) {
         try{
            assigner_Clusters(s, p);
            ajuster_Centroids(s);
        }catch(Exception e){ System.out.print(e.getCause());}
        }
    }

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









