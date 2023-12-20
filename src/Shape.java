import java.util.ArrayList;

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

public class Shape {

        public ArrayList<Double> E34;
        public ArrayList<Double> GFD;
        public ArrayList<Double> SA;
        public ArrayList<Double> F0;
        private int Cluster;


        public Shape() {
            this.E34 =null;
            this.GFD =null;
            this.SA = null;
            this.F0 = null;
        }

        public Shape(ArrayList<Double> E34, ArrayList<Double> GFD, ArrayList<Double> SA, ArrayList<Double> F0) {
            this.E34 = E34;
            this.GFD = GFD;
            this.SA = SA;
            this.F0 = F0;
        }

        public ArrayList<Double> getE34() {
            return E34;
        }
        public void setE34(ArrayList<Double> E34) {
            this.E34 = E34;
        }

        public ArrayList<Double> getSA() {
            return SA;
        }
        public void setSA(ArrayList<Double> SA) {
            this.SA = SA;
        }

        public ArrayList<Double> getGFD() {
            return GFD;
        }
        public void setGFD(ArrayList<Double> GFD) {
            this.GFD = GFD;
        }

        public ArrayList<Double> getF0() {
            return F0;
        }
        public void setF0(ArrayList<Double> F0) {
            this.F0 = F0;
        }

        public void setCluster(int x){
            this.Cluster=x;
        }

        public int getCluster(){
            return this.Cluster;
        }

    }


