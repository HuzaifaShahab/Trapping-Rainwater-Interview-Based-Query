public class TrapingRainWater {
    public static int trappingRainwater (int []height){
        int waterLevel ;            // wL = min of (Bar-Heights)
        int waterTrapped=0;        // wT = wL-Bar-Height

        int []leftMax = new int[height.length] ;
            leftMax[0] = height[0] ;
            for (int i=1 ; i< leftMax.length ; i++){ // Computing Left Max boundary.
                leftMax[i] = Math.max(height[i] , leftMax[i-1]) ;  // {4,4,4,6,6,6,6}
            }

        int []rightMax = new int[height.length] ;
            rightMax[rightMax.length-1] = height[height.length-1] ;
            for(int i = height.length-2 ; i>=0 ; i--){    // Computing boundary to the right.
                rightMax[i] = Math.max(height[i] , rightMax[i+1]) ;  // {6,6,6,6,5,5,5}
            }

            for (int i = 0 ; i< height.length ; i++){    // Actual Logic.
                 waterLevel = Math.min(leftMax[i],rightMax[i]) ; // Finding water level.
                 waterTrapped += waterLevel - height[i] ;
            }
        return waterTrapped ;
    }
    public static void main(String[] args) {
        int []height = {4,2,0,6,3,2,5} ; // Passing array by reference to the function.
            System.out.println("Total volume of water trapped is : "+trappingRainwater(height));
    }
}
