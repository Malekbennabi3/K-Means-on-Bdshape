
# K-Means on BDShape 
In this project, I tried to apply the [K-Means](#Algorithm) clustering algorithm to part of the BDShape data set (9x11).

![image](https://github.com/Malekbennabi3/K-Means-on-Bdshape/assets/56505955/52029467-9972-41a5-89f7-c68e3601946c)


Then i tried to evaluate the performance of this algorithm on the 4 feature (E34, GFD, SA, F0):

*E34: corresponds to the degree of ellipticity calculated on 
16 cross-sections of the shape.*

*GFD: corresponds to a generic Fourier descriptor (characteristic vector of 36 values corresponding to radial and angular frequencies).*

*SA: corresponds to a Signature calculated at 90 angles.*

*F0: corresponds to an evaluation of shape distortions 
in 128 directions.*

And for each selected feature i tried to evaluate the algorithm according to 4 criteria (Execution time, Confusion matrix, Precision and Recall).

To calculate the precision and the recall (Repeal) of a given class, i used the following formulas:

$$Precision(c)=Nb\ truepositives_c/Nb\ cluster_c$$

$$Recall(c)=Nb\ truepositives_c/Nb\ elements_c$$

where:          
- **c:** A shape's class [1-9].  
- **True positive:** The value correctly assigned to a cluster **c** and which belongs to the class **c**.

I also used 3 different types of distance:

-Manhattan distance: The norm p=1, it's calculated as follows:
$$Dist_{Manh}(x,y)=\sum_{i=1}^{d}\left |x_i-y_i \right |$$

-Euclidean distance: The norm p=2 and is calculated as follows:
$$Dist_{Euc}(x,y)=(\sum_{i=1}^{d}\left |x_i-y_i \right |^2)^{1/2}$$

-Minkowski distance: It's a generalization of the distance equation where the norm p>2, it is calculated with the formula:  
$$Dist_{Mink}(x,y)=(\sum_{i=1}^{d}\left |x_i-y_i \right |^p)^{1/p}$$


I should also point out the fact that the K-Means algorithm is a non-determinist algorithm (given the same input and starting conditions, it can exhibit different behaviors or produce different outputs on different executions).

For the choice of iterations, i have left the choice to the user, but generally 10 iterations are enough to see the evolution of the algorithm, especially as this shape dataset contains only 99 shapes.

For the choice of the value of k, i have also left the choice to the user, but i must emphasize that the choice of k in the K-Means algorithm is a NP-difficult Problem (Non-deterministic Polynomial-time hard), either way a value of k=9 is conceivable as the classes are fairly heterogeneous (there are 9 classes in our database and 11 samples in each class).

To plot the graphical representations in this project, i used the JFreeChart java library, which you can find in the github repository (https://github.com/jfree/jfreechart.git) or in .jar form on the web (http://www.jfree.org/jfreechart/) or import it as a dependency in the file 'pom.xml' using maven :

```
<dependencies>
    <!-- Other dependencies -->
    
    <!-- JFreeChart dependency -->
    <dependency>
        <groupId>org.jfree</groupId>
        <artifactId>jfreechart</artifactId>
        <version>1.5.3</version> <!-- Use the latest version available -->
    </dependency>
</dependencies>
```

In the end, for each shape of the dataset; files were generated to facilitate processing.

The file extension defines the type of method that has been calculated on the associated image. In this project: SxxNyyy.E34 for ellipticity.

(for example the file *s003n007.GFD* represents  Generic Fourier Descriptors of the $7^{th}$ sample of the $3^{rd}$ class).
There is also a .PNG file for every shape for a better comprehension.

**Please do not hesitate to report any error or add suggestions for this project.**

<a id="Algorithm"></a>
## The K-Means Algorithm 
K-means clustering is an unsupervised partitional algorithm that partitions a dataset into k groups or clusters. Each data point is assigned to the cluster that is 
closest to it based on the distance between the data point and the cluster center. The cluster centers are initially arbitrary but are then updated at each 
iteration of the algorithm to minimize intra-class inertia, which is the sum of the distances between each data point and its respective cluster center.
K-means is a simple and effective algorithm that is often used for clustering data in areas such as machine learning, data science, and data analysis. However, it 
can be sensitive to outliers and non-linear data.

Here are the execution steps for this algorithm: 
1. Select an initial partition with k clusters (repeat steps 2 through 4 until the cluster membership stabilizes). 

2. Generate a new partition by assigning each pattern to its closest cluster center using the distance measurements (Manhattan, Euclidean or Minkowski's distance). 

3. Compute new cluster centers as the centroids of the clusters. 

4. Repeat steps 2 and 3 until an optimum value of the criterion function is found (when a local minimum is found or a predefined number of iterations are completed -like in our case-). 
## BDShape:
BDShape is a free, open geometric data library developed by the Shapely project team. It is written in Python and can be used to manipulate geometric data of various kinds, such as points, lines, polygons, surfaces and volumes.

BDShape provides a comprehensive, easy-to-use API for creating, reading, writing and manipulating geometric data. It is compatible with a wide range of geometric data formats, such as GeoJSON, Shapefile, WKT and WKB.

BDShape is used in a variety of applications, such as cartography, geolocation, image processing and artificial intelligence. It is also used in open source projects such as OpenStreetMap and QGIS.

It's also available on github via the link:
https://github.com/shapely/shapely
