class FoodRatings {

    Map<String, Food> foodMap = new HashMap<>();
    Map<String, TreeSet<Food>> cuisineMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        
        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);

            foodMap.put(foods[i], food);
            
            if (!cuisineMap.containsKey(cuisines[i])) {
                TreeSet<Food> newTree1 = new TreeSet<>();
                newTree1.add(food);
                cuisineMap.put(cuisines[i], newTree1);
            } else {
                TreeSet<Food> getTree = cuisineMap.get(cuisines[i]);
                getTree.add(food);
            }
        }

        
    }
    
    public void changeRating(String food, int newRating) {
        Food foodC = foodMap.get(food);
        TreeSet<Food> ts = cuisineMap.get(foodC.cuisine);
        ts.remove(foodC);

        foodC.rating = newRating;
        ts.add(foodC);

        foodMap.put(food, foodC);
        cuisineMap.put(foodC.cuisine, ts);
    }
    
    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().food;
    }


    public static class Food implements Comparable<Food> {

        String food;
        String cuisine;
        int rating;

        public Food(String food, String cuisine, int rating) {
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        @Override
        public int compareTo(Food o) {
            if (rating != o.rating) return Integer.compare(o.rating, rating);
            return food.compareTo(o.food);
        }
    }
}



/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */