package com.example.myapp.data.model

import com.example.myapp.R

class FakeDatabase(var title:String) {
    var database = ArrayList<RecipeModel>()

    fun create(){
        database.add(RecipeModel("tom","Сream of mushroom soup", "first course", R.drawable.cream_soup.toString(), arrayListOf("4 tablespoons butter", "1 tablespoon oil", "2 onions diced", "4 cloves garlic minced", "1 1/2 pounds (750 g) fresh brown mushrooms sliced", "4 teaspoons chopped thyme divided", "1/2 cup Marsala wine (any dry red or white wine)", "6 tablespoons all-purpose flour", "4 cups low sodium chicken broth or stock", "1-2 teaspoons salt adjust to taste", "1/2-1 teaspoons black cracked pepper adjust to taste", "2 beef bouillon cubes, crumbled", "1 cup heavy cream or half and half (sub with evaporated milk)", "Chopped fresh parsley and thyme to serve"), arrayListOf("Heat butter and oil in a large pot over medium-high heat until melted. Sauté onion for 2 to 3 minutes until softened. Cook garlic until fragrant, about 1 minute.", "Add mushrooms and 2 teaspoons thyme, cook for 5 minutes. Pour in wine and allow to cook for 3 minutes.", "Sprinkle mushrooms with flour, mix well and cook for 2 minutes. Add stock, mix again and bring to a boil. Reduce heat to low-medium heat, season with salt, pepper and crumbled bouillon cubes.", "Cover and allow to simmer for 10-15 minutes, while occasionally stirring, until thickened.", "Reduce heat to low, stir in cream or half and half. Allow to gently simmer (do not boil). Adjust salt and pepper to your taste.", "Mix in parsley and remaining thyme. Serve warm."), 6))
        database.add(RecipeModel("kkate","Burger", "main course", R.drawable.burger.toString(), arrayListOf("1 small onion, diced", "500g good-quality beef mince", "1 egg", "1 tbsp vegetable oil", "4 burger buns", "All or any of the following to serve: sliced tomato, beetroot, horseradish sauce, mayonnaise, ketchup, handful iceberg lettuce, rocket, watercress"), arrayListOf("Tip 500g beef mince into a bowl with 1 small diced onion and 1 egg, then mix.", "ivide the mixture into four. Lightly wet your hands. Carefully roll the mixture into balls, each about the size of a tennis ball.", "Set in the palm of your hand and gently squeeze down to flatten into patties about 3cm thick. Make sure all the burgers are the same thickness so that they will cook evenly.", "Put on a plate, cover with cling film and leave in the fridge to firm up for at least 30 mins.", "Heat the barbecue to medium hot (there will be white ash over the red hot coals – about 40 mins after lighting). Lightly brush one side of each burger with vegetable oil.", "Place the burgers, oil-side down, on the barbecue. Cook for 5 mins until the meat is lightly charred. Don’t move them around or they may stick.", "Oil the other side, then turn over using tongs. Don’t press down on the meat, as that will squeeze out the juices.", "Cook for 5 mins more for medium. If you like your burgers pink in the middle, cook 1 min less each side. For well done, cook 1 min more.", "Take the burgers off the barbecue. Leave to rest on a plate so that all the juices can settle inside.", "Slice four burger buns in half. Place, cut-side down, on the barbecue rack and toast for 1 min until they are lightly charred. Place a burger inside each bun, then top with your choice of accompaniment."), 1))
        database.add(RecipeModel("tom","Lasagna", "main course", R.drawable.lasagna.toString(), arrayListOf("3/4 lb. lasagna noodles", "1 tsp. extra-virgin olive oil, plus more for drizzling", "2 lb. ground beef", "4 cloves garlic, minced", "2 tsp. dried oregano", "Kosher salt", "Freshly ground black pepper", "2 (32-0z.) jars marinara", "16 oz. whole milk ricotta", "1/2 c. freshly grated Parmesan, divided", "1/4 c. chopped parsley, plus more for garnish", "1 large egg", "2 lb. sliced mozzarella"), arrayListOf("Preheat oven to 375º. In a large pot of salted boiling water, cook pasta according to package directions until al dente, less 2 minutes. Drain and drizzle a bit of olive oil to prevent noodles from sticking together.","Meanwhile, in a large pot over medium-high heat, heat oil. Cook ground beef until no longer pink, breaking up with a wooden spoon. Remove from heat and drain fat. Return beef to skillet and add garlic and oregano and cook, stirring, for 1 minute. Season with salt and pepper, then add marinara and stir until warmed through. ", "Combine ricotta, 1/4 cup Parmesan, parsley, and egg in a large mixing bowl and season with salt and pepper. Set aside.", "In a large casserole dish, evenly spread a quarter of the meat sauce across the bottom of the dish, then top with a single layer of lasagna noodles, a layer of ricotta mixture, a single layer of mozzarella, and a layer of meat sauce. Repeat layers, topping the last layer of noodles with meat sauce, Parmesan, and mozzarella.", "Cover with foil and bake for 15 minutes, then increase temperature to 400º and bake uncovered for 18 to 20 minutes.", "Garnish with parsley before serving."), 4))
        database.add(RecipeModel("tom","Apple Pie", "dessert", R.drawable.pie.toString(), arrayListOf("1/2 cup sugar", "1/2 cup packed brown sugar", "3 tablespoons all-purpose flour", "1 teaspoon ground cinnamon", "1/4 teaspoon ground ginger", "1/4 teaspoon ground nutmeg", "6 to 7 cups thinly sliced peeled tart apples", "1 tablespoon lemon juice", "Dough for double-crust pie", "1 tablespoon butter", "1 large egg white", "Additional sugar"), arrayListOf("Preheat oven to 375°. In a small bowl, combine sugars, flour and spices; set aside. In a large bowl, toss apples with lemon juice. Add sugar mixture; toss to coat.", "On a lightly floured surface, roll one half of dough to a 1/8-in.-thick circle; transfer to a 9-in. pie plate. Trim even with rim. Add filling; dot with butter. Roll remaining dough to a 1/8-in.-thick circle. Place over filling. Trim, seal and flute edge. Cut slits in top. Beat egg white until foamy; brush over crust. Sprinkle with sugar. Cover edge loosely with foil.", "Bake 25 minutes. Remove foil; bake until crust is golden brown and filling is bubbly, 20-25 minutes longer. Cool on a wire rack."), 8))
        database.add(RecipeModel("tom","Muffins", "dessert", R.drawable.muffins.toString(), arrayListOf("2 medium eggs", "125ml vegetable oil", "250ml semi-skimmed milk", "250g golden caster sugar", "400g self-raising flour (or same quantity plain flour and 3 tsp baking powder)", "1 tsp salt", "100g chocolate chips or dried fruit such as sultanas or dried cherries (optional)"), arrayListOf("Heat oven to 200C/180C fan/gas 6. Line 2 muffin trays with paper muffin cases. In a large bowl beat 2 medium eggs lightly with a handheld electric mixer for 1 min.", "Add 125ml vegetable oil and 250ml semi-skimmed milk and beat until just combined then add 250g golden caster sugar and whisk until you have a smooth batter.", "Sift in 400g self-raising flour and 1 tsp salt (or 400g plain flour and 3 tsp baking powder if using) then mix until just smooth. Be careful not to over-mix the batter as this will make the muffins tough.", "Stir in 100g chocolate chips or dried fruit if using.", "Fill muffin cases two-thirds full and bake for 20-25 mins, until risen, firm to the touch and a skewer inserted in the middle comes out clean. If the trays will not fit on 1 shelf, swap the shelves around after 15 mins of cooking.", "Leave the muffins in the tin to cool for a few mins and transfer to a wire rack to cool completely."),12))
        database.add(RecipeModel("tom","Pina Colada", "drinks", R.drawable.colada.toString(), arrayListOf("120ml pineapple juice","60ml white rum","60ml coconut cream","wedge of pineapple, to garnish (optional)"), arrayListOf("Pulse all the ingredients along with a handful of ice in a blender until smooth. Pour into a tall glass and garnish as you like."), 1))
    }

    fun add(name: String, type: String, image: Int, ingredients: ArrayList<String>, description: ArrayList<String>, portions: Int) {
        database.add(RecipeModel("kkate", name, type,image.toString(), ingredients,description, portions))
    }

    fun get(): ArrayList<RecipeModel> {
        create()
        return database
    }
    fun get(id: Int): RecipeModel {
        create()
        return database[id]
    }
}