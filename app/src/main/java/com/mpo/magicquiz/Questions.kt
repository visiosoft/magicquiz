package com.mpo.magicquiz

data class Question(
    val question: String,
    val options: List<String>,
    val correctAnswer: Int,
    val hints: List<String>
)

object Questions {
    val level1Questions = listOf(
        Question(
            "What is the capital of Japan?",
            listOf("Seoul", "Beijing", "Tokyo", "Bangkok"),
            2,
            listOf("Think about the main city of Japan.", "Tokyo is the capital and largest city of Japan.", "Japan's capital is known for its technology and culture.")
        ),
        Question(
            "Which animal is known as the 'king of the jungle'?",
            listOf("Tiger", "Lion", "Elephant", "Gorilla"),
            1,
            listOf("Think about which animal is called the 'king of the jungle'.", "Lions are often called the 'king of the jungle' due to their strength.", "This animal is known for its majestic mane and roar.")
        ),
        Question(
            "What is the main ingredient in bread?",
            listOf("Rice", "Corn", "Wheat", "Potato"),
            2,
            listOf("Think about what grain is used to make flour for bread.", "Wheat is the primary grain used to make bread flour.", "This grain is ground into flour to make most bread.")
        ),
        Question(
            "How many colors are in a rainbow?",
            listOf("5", "6", "7", "8"),
            2,
            listOf("Think about the traditional colors of a rainbow.", "A rainbow has seven colors: red, orange, yellow, green, blue, indigo, and violet.", "Remember the acronym ROYGBIV for rainbow colors.")
        ),
        Question(
            "Which planet is closest to the Sun?",
            listOf("Venus", "Mars", "Mercury", "Earth"),
            2,
            listOf("Think about the order of planets from the Sun.", "Mercury is the first planet from the Sun.", "This planet has the shortest orbit around the Sun.")
        ),
        Question(
            "What is the largest organ in the human body?",
            listOf("Heart", "Brain", "Liver", "Skin"),
            3,
            listOf("Think about which organ covers your entire body.", "The skin is the largest organ and covers the entire body surface.", "This organ protects you from the environment and regulates temperature.")
        ),
        Question(
            "How many legs does a spider have?",
            listOf("6", "8", "10", "12"),
            1,
            listOf("Think about how many legs spiders typically have.", "Spiders have eight legs, unlike insects which have six.", "This number is more than insects but less than centipedes.")
        ),
        Question(
            "What is the name of the world's largest rainforest?",
            listOf("Congo Rainforest", "Amazon Rainforest", "Borneo Rainforest", "Daintree Rainforest"),
            1,
            listOf("The Congo Rainforest is located in Africa.", "The Amazon Rainforest is the largest rainforest in the world.", "Borneo Rainforest is located in Southeast Asia.")
        ),
        Question(
            "Which animal can change its color to match its surroundings?",
            listOf("Frog", "Chameleon", "Snake", "Lizard"),
            1,
            listOf("Chameleons are known for their ability to change color.", "Snakes are not known for changing color.", "Lizards are not known for changing color.")
        ),
        Question(
            "What is the main ingredient in chocolate?",
            listOf("Vanilla", "Cocoa", "Coffee", "Sugar"),
            1,
            listOf("Cocoa is the main ingredient in chocolate.", "Vanilla is a common flavor in chocolate.", "Sugar is a common ingredient in chocolate.")
        ),
        Question(
            "What is the capital of India?",
            listOf("Mumbai", "New Delhi", "Bangalore", "Kolkata"),
            1,
            listOf("New Delhi is the capital of India.", "Mumbai is a large city in India.", "Bangalore is a city in India.")
        ),
        Question(
            "Which animal is known as the 'ship of the desert'?",
            listOf("Horse", "Camel", "Elephant", "Donkey"),
            1,
            listOf("Camels are known for their ability to survive in the desert.", "Horses are not known for surviving in the desert.", "Donkeys are not known for surviving in the desert.")
        ),
        Question(
            "What is the main ingredient in pizza?",
            listOf("Cheese", "Tomato", "Flour", "Meat"),
            2,
            listOf("Cheese is a common ingredient in pizza.", "Tomatoes are not a common ingredient in pizza.", "Flour is a common ingredient in pizza.")
        ),
        Question(
            "Which planet is known as the 'Blue Planet'?",
            listOf("Mars", "Venus", "Earth", "Neptune"),
            2,
            listOf("Earth is often referred to as the Blue Planet.", "Venus is not known as the Blue Planet.", "Mars is not known as the Blue Planet.")
        ),
        Question(
            "What is the name of the world's largest mountain?",
            listOf("K2", "Mount Everest", "Kangchenjunga", "Lhotse"),
            1,
            listOf("Mount Everest is the highest mountain in the world.", "K2 is a mountain in the Karakoram range.", "Kangchenjunga is a mountain in the Himalayas.")
        ),
        Question(
            "Which fruit is known as the 'king of fruits' in Southeast Asia?",
            listOf("Mango", "Durian", "Papaya", "Pineapple"),
            1,
            listOf("Mangoes are known for their sweetness.", "Durian is a fruit with a strong odor.", "Papayas are not known as the king of fruits in Southeast Asia.")
        ),
        Question(
            "What is the name of the world's largest river?",
            listOf("Nile", "Amazon", "Yangtze", "Mississippi"),
            1,
            listOf("The Nile is the longest river in the world.", "The Amazon is the largest river in the world.", "The Yangtze is the longest river in China.")
        ),
        Question(
            "Which animal is known as the 'king of the Arctic'?",
            listOf("Arctic Fox", "Polar Bear", "Walrus", "Seal"),
            1,
            listOf("Polar Bears are known for their thick fur.", "Walruses are not known for being the king of the Arctic.", "Seals are not known for being the king of the Arctic.")
        ),
        Question(
            "What is the name of the world's largest island?",
            listOf("Madagascar", "Greenland", "Borneo", "New Guinea"),
            1,
            listOf("Madagascar is an island country.", "Greenland is an island country.", "Borneo is an island country.")
        ),
        Question(
            "Which planet is known as the 'Morning Star'?",
            listOf("Mars", "Venus", "Mercury", "Jupiter"),
            1,
            listOf("Venus is sometimes called the Morning Star.", "Mercury is not known as the Morning Star.", "Jupiter is not known as the Morning Star.")
        ),
        Question(
            "What is the name of the world's largest living bird?",
            listOf("Emu", "Ostrich", "Cassowary", "Albatross"),
            1,
            listOf("Emu is a large bird native to Australia.", "Ostrich is a large bird native to Africa.", "Cassowary is a large bird native to Australia.")
        ),
        Question(
            "Which animal is known as the 'king of the savanna'?",
            listOf("Tiger", "Lion", "Elephant", "Giraffe"),
            1,
            listOf("Lions are the largest cats in the world.", "Elephants are the largest land animal.", "Giraffes are the tallest living animal.")
        ),
        Question(
            "What is the name of the world's largest living reptile?",
            listOf("Komodo Dragon", "Saltwater Crocodile", "Green Anaconda", "Leatherback Turtle"),
            1,
            listOf("Komodo Dragons are known for their large size.", "Saltwater Crocodiles are not known for being the largest reptile.", "Green Anacondas are not known for being the largest reptile.")
        ),
        Question(
            "Which planet is known as the 'Red Planet'?",
            listOf("Venus", "Mars", "Jupiter", "Saturn"),
            1,
            listOf("Mars is known as the Red Planet.", "Venus is not known as the Red Planet.", "Jupiter is not known as the Red Planet.")
        ),
        Question(
            "What is the name of the world's largest living fish?",
            listOf("Blue Whale", "Whale Shark", "Great White Shark", "Manta Ray"),
            1,
            listOf("Blue Whales are the largest animals in the world.", "Whale Sharks are not known for being the largest living fish.", "Great White Sharks are not known for being the largest living fish.")
        )
    )

    val level2Questions = listOf(
        Question(
            "Which country has the most natural lakes?",
            listOf("United States", "Canada", "Russia", "Finland"),
            1,
            listOf("Canada has the most natural lakes.", "Russia has the most natural lakes.", "Finland has the most natural lakes.")
        ),
        Question(
            "What is the largest bone in the human body?",
            listOf("Skull", "Femur", "Spine", "Pelvis"),
            1,
            listOf("The femur is the largest bone in the human body.", "The spine is not the largest bone in the human body.", "The pelvis is not the largest bone in the human body.")
        ),
        Question(
            "Which planet has the most moons?",
            listOf("Jupiter", "Saturn", "Uranus", "Neptune"),
            1,
            listOf("Jupiter has the most moons.", "Saturn has the most moons.", "Uranus has the most moons.")
        ),
        Question(
            "What is the name of the world's largest coral reef system?",
            listOf("Great Barrier Reef", "Belize Barrier Reef", "New Caledonia Barrier Reef", "Red Sea Coral Reef"),
            0,
            listOf("The Great Barrier Reef is the largest coral reef system in the world.", "The Belize Barrier Reef is located in the Caribbean Sea.", "The New Caledonia Barrier Reef is located in the Pacific Ocean.")
        ),
        Question(
            "Which element has the chemical symbol 'Au'?",
            listOf("Silver", "Gold", "Copper", "Aluminum"),
            1,
            listOf("Gold is a precious metal.", "Silver is not known for having the chemical symbol 'Au'.", "Copper is not known for having the chemical symbol 'Au'.")
        ),
        Question(
            "What is the name of the world's largest waterfall?",
            listOf("Victoria Falls", "Angel Falls", "Niagara Falls", "Iguazu Falls"),
            1,
            listOf("Victoria Falls is the largest waterfall in the world.", "Angel Falls is located in Venezuela.", "Niagara Falls is located in the United States.")
        ),
        Question(
            "Which country has the most time zones?",
            listOf("United States", "Russia", "France", "United Kingdom"),
            2,
            listOf("The United States has the most time zones.", "Russia has the most time zones.", "France has the most time zones.")
        ),
        Question(
            "What is the name of the world's largest living organism?",
            listOf("Blue Whale", "Giant Sequoia", "Great Barrier Reef", "Pando Aspen Grove"),
            3,
            listOf("Blue Whales are the largest animals in the world.", "Giant Sequoia is the largest tree in the world.", "The Great Barrier Reef is the largest living organism in the world.")
        ),
        Question(
            "Which planet has the longest day?",
            listOf("Mercury", "Venus", "Mars", "Jupiter"),
            1,
            listOf("Mercury has the shortest day in the solar system.", "Venus has the longest day in the solar system.", "Mars has the shortest day in the solar system.")
        ),
        Question(
            "What is the name of the world's largest volcano?",
            listOf("Mount Everest", "Mauna Loa", "Mount Kilimanjaro", "Mount Fuji"),
            1,
            listOf("Mauna Loa is the largest volcano in the world.", "Mount Kilimanjaro is a mountain in Africa.", "Mount Fuji is a mountain in Japan.")
        ),
        Question(
            "Which animal has the longest lifespan?",
            listOf("Elephant", "Tortoise", "Bowhead Whale", "Greenland Shark"),
            3,
            listOf("Tortoises are known for their long lifespan.", "Bowhead Whales are not known for having the longest lifespan.", "Greenland Sharks are not known for having the longest lifespan.")
        ),
        Question(
            "What is the name of the world's largest canyon?",
            listOf("Grand Canyon", "Yarlung Tsangpo Canyon", "Kali Gandaki Gorge", "Cotahuasi Canyon"),
            1,
            listOf("The Grand Canyon is the largest canyon in the world.", "Yarlung Tsangpo Canyon is located in Tibet.", "Kali Gandaki Gorge is located in Nepal.")
        ),
        Question(
            "Which country has the most islands?",
            listOf("Indonesia", "Sweden", "Finland", "Norway"),
            1,
            listOf("Indonesia has the most islands in the world.", "Sweden has the most islands in the world.", "Finland has the most islands in the world.")
        ),
        Question(
            "What is the name of the world's largest living mammal?",
            listOf("Blue Whale", "African Elephant", "Giraffe", "Hippopotamus"),
            0,
            listOf("Blue Whales are the largest animals in the world.", "African Elephants are the largest land animals in the world.", "Giraffes are the tallest living animals.")
        ),
        Question(
            "What is the name of the world's largest living fish?",
            listOf("Blue Whale", "Whale Shark", "Great White Shark", "Manta Ray"),
            1,
            listOf("Blue Whales are the largest animals in the world.", "Whale Sharks are not known for being the largest living fish.", "Great White Sharks are not known for being the largest living fish.")
        ),
        Question(
            "What is the name of the world's largest living land mammal?",
            listOf("African Bush Elephant", "Asian Elephant", "Giraffe", "Hippopotamus"),
            0,
            listOf("African Bush Elephants are the largest land mammals in the world.", "Asian Elephants are the largest land mammals in the world.", "Giraffes are the tallest living animals.")
        ),
        Question(
            "Which planet has the most rings?",
            listOf("Jupiter", "Saturn", "Uranus", "Neptune"),
            1,
            listOf("Saturn has the most rings in the solar system.", "Uranus has the most rings in the solar system.", "Neptune has the most rings in the solar system.")
        ),
        Question(
            "What is the name of the world's largest desert?",
            listOf("Sahara Desert", "Antarctic Desert", "Arctic Desert", "Gobi Desert"),
            1,
            listOf("The Sahara Desert is the largest desert in the world.", "The Antarctic Desert is located in Antarctica.", "The Arctic Desert is located in the Arctic Ocean.")
        ),
        Question(
            "Which animal has the strongest bite force?",
            listOf("Lion", "Tiger", "Saltwater Crocodile", "Great White Shark"),
            2,
            listOf("Saltwater Crocodiles have the strongest bite force in the world.", "Great White Sharks are not known for having the strongest bite force.", "Lions and Tigers are not known for having the strongest bite force.")
        ),
        Question(
            "What is the name of the world's largest living land mammal?",
            listOf("African Bush Elephant", "Asian Elephant", "Giraffe", "Hippopotamus"),
            0,
            listOf("African Bush Elephants are the largest land mammals in the world.", "Asian Elephants are the largest land mammals in the world.", "Giraffes are the tallest living animals.")
        ),
        Question(
            "Which country has the most active volcanoes?",
            listOf("Japan", "Indonesia", "United States", "Philippines"),
            1,
            listOf("Japan has the most active volcanoes in the world.", "Indonesia has the most active volcanoes in the world.", "The United States has the most active volcanoes in the world.")
        ),
        Question(
            "What is the name of the world's largest living land carnivore?",
            listOf("Polar Bear", "Brown Bear", "Tiger", "Lion"),
            0,
            listOf("Polar Bears are the largest land carnivores in the world.", "Brown Bears are not known for being the largest land carnivores.", "Lions and Tigers are not known for being the largest land carnivores.")
        ),
        Question(
            "Which planet has the most extreme temperature variations?",
            listOf("Mercury", "Venus", "Mars", "Jupiter"),
            0,
            listOf("Mercury has the most extreme temperature variations in the solar system.", "Venus has the most extreme temperature variations in the solar system.", "Mars has the most extreme temperature variations in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living amphibian?",
            listOf("Giant Salamander", "Bullfrog", "Axolotl", "Cane Toad"),
            0,
            listOf("Giant Salamanders are not known for being the largest living amphibians.", "Bullfrogs are not known for being the largest living amphibians.", "Axolotls are not known for being the largest living amphibians.")
        ),
        Question(
            "Which country has the most natural hot springs?",
            listOf("Japan", "Iceland", "New Zealand", "United States"),
            1,
            listOf("Japan has the most natural hot springs in the world.", "Iceland has the most natural hot springs in the world.", "New Zealand has the most natural hot springs in the world.")
        ),
        Question(
            "What is the name of the world's largest living single-celled organism?",
            listOf("Amoeba", "Paramecium", "Valonia ventricosa", "Stentor"),
            2,
            listOf("Amoeba is a single-celled organism.", "Paramecium is a single-celled organism.", "Valonia ventricosa is a single-celled organism.")
        ),
        Question(
            "Which planet has the most extreme pressure at its surface?",
            listOf("Mercury", "Venus", "Mars", "Jupiter"),
            1,
            listOf("Mercury has the most extreme pressure in the solar system.", "Venus has the most extreme pressure in the solar system.", "Mars has the most extreme pressure in the solar system.")
        )
    )

    val level3Questions = listOf(
        Question(
            "What is the name of the world's largest living land invertebrate?",
            listOf("Giant Squid", "Colossal Squid", "Giant Isopod", "Japanese Spider Crab"),
            3,
            listOf("Giant Squids are the largest living invertebrates in the world.", "Colossal Squids are not known for being the largest living invertebrates.", "Giant Isopods are not known for being the largest living invertebrates.")
        ),
        Question(
            "Which country has the most UNESCO World Heritage Sites?",
            listOf("China", "Italy", "Spain", "France"),
            1,
            listOf("China has the most UNESCO World Heritage Sites in the world.", "Italy has the most UNESCO World Heritage Sites in the world.", "Spain has the most UNESCO World Heritage Sites in the world.")
        ),
        Question(
            "What is the name of the world's largest living tree by volume?",
            listOf("Hyperion", "General Sherman", "Helios", "Icarus"),
            1,
            listOf("General Sherman is the largest living tree by volume in the world.", "Hyperion is a tree in California.", "Helios is a tree in California.")
        ),
        Question(
            "Which planet has the most extreme atmospheric pressure?",
            listOf("Mercury", "Venus", "Earth", "Jupiter"),
            1,
            listOf("Mercury has the most extreme atmospheric pressure in the solar system.", "Venus has the most extreme atmospheric pressure in the solar system.", "Earth has the most extreme atmospheric pressure in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living land animal?",
            listOf("African Bush Elephant", "Asian Elephant", "Giraffe", "Hippopotamus"),
            0,
            listOf("African Bush Elephants are the largest land animals in the world.", "Asian Elephants are the largest land animals in the world.", "Giraffes are the tallest living animals.")
        ),
        Question(
            "Which country has the most natural resources?",
            listOf("United States", "Russia", "China", "Australia"),
            1,
            listOf("The United States has the most natural resources in the world.", "Russia has the most natural resources in the world.", "China has the most natural resources in the world.")
        ),
        Question(
            "What is the name of the world's largest living primate?",
            listOf("Gorilla", "Orangutan", "Chimpanzee", "Bonobo"),
            0,
            listOf("Gorillas are the largest primates in the world.", "Orangutans are the largest primates in the world.", "Chimpanzees are the largest primates in the world.")
        ),
        Question(
            "Which planet has the most extreme magnetic field?",
            listOf("Earth", "Jupiter", "Saturn", "Neptune"),
            1,
            listOf("Earth has the most extreme magnetic field in the solar system.", "Jupiter has the most extreme magnetic field in the solar system.", "Saturn has the most extreme magnetic field in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living marsupial?",
            listOf("Kangaroo", "Koala", "Tasmanian Devil", "Wombat"),
            0,
            listOf("Kangaroos are the largest marsupials in the world.", "Koalas are the largest marsupials in the world.", "Tasmanian Devils are the largest marsupials in the world.")
        ),
        Question(
            "Which country has the most diverse ecosystem?",
            listOf("Brazil", "Indonesia", "Colombia", "Peru"),
            2,
            listOf("Brazil has the most diverse ecosystem in the world.", "Indonesia has the most diverse ecosystem in the world.", "Colombia has the most diverse ecosystem in the world.")
        ),
        Question(
            "What is the name of the world's largest living rodent?",
            listOf("Beaver", "Capybara", "Porcupine", "Nutria"),
            1,
            listOf("Beavers are the largest rodents in the world.", "Capybaras are the largest rodents in the world.", "Porcupines are the largest rodents in the world.")
        ),
        Question(
            "Which planet has the most extreme seasons?",
            listOf("Earth", "Mars", "Uranus", "Neptune"),
            2,
            listOf("Earth has the most extreme seasons in the solar system.", "Mars has the most extreme seasons in the solar system.", "Uranus has the most extreme seasons in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living carnivorous marsupial?",
            listOf("Tasmanian Devil", "Quoll", "Numbat", "Bilby"),
            0,
            listOf("Tasmanian Devils are the largest carnivorous marsupials in the world.", "Quolls are not known for being the largest carnivorous marsupials.", "Numbats are not known for being the largest carnivorous marsupials.")
        ),
        Question(
            "Which country has the most endemic species?",
            listOf("Australia", "Madagascar", "Brazil", "Indonesia"),
            1,
            listOf("Australia has the most endemic species in the world.", "Madagascar has the most endemic species in the world.", "Brazil has the most endemic species in the world.")
        ),
        Question(
            "What is the name of the world's largest living land carnivore?",
            listOf("Polar Bear", "Brown Bear", "Tiger", "Lion"),
            0,
            listOf("Polar Bears are the largest land carnivores in the world.", "Brown Bears are not known for being the largest land carnivores.", "Lions and Tigers are not known for being the largest land carnivores.")
        ),
        Question(
            "Which planet has the most extreme orbital eccentricity?",
            listOf("Mercury", "Venus", "Mars", "Pluto"),
            3,
            listOf("Mercury has the most extreme orbital eccentricity in the solar system.", "Venus has the most extreme orbital eccentricity in the solar system.", "Mars has the most extreme orbital eccentricity in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living land herbivore?",
            listOf("African Bush Elephant", "Asian Elephant", "Giraffe", "Hippopotamus"),
            0,
            listOf("African Bush Elephants are the largest land herbivores in the world.", "Asian Elephants are the largest land herbivores in the world.", "Giraffes are the tallest living herbivores.")
        ),
        Question(
            "Which country has the most diverse climate zones?",
            listOf("United States", "Russia", "China", "India"),
            1,
            listOf("The United States has the most diverse climate zones in the world.", "Russia has the most diverse climate zones in the world.", "China has the most diverse climate zones in the world.")
        ),
        Question(
            "What is the name of the world's largest living land omnivore?",
            listOf("Brown Bear", "Polar Bear", "Grizzly Bear", "Black Bear"),
            0,
            listOf("Brown Bears are the largest land omnivores in the world.", "Polar Bears are not known for being the largest land omnivores.", "Grizzly Bears are not known for being the largest land omnivores.")
        ),
        Question(
            "Which planet has the most extreme axial tilt?",
            listOf("Earth", "Mars", "Uranus", "Neptune"),
            2,
            listOf("Earth has the most extreme axial tilt in the solar system.", "Mars has the most extreme axial tilt in the solar system.", "Uranus has the most extreme axial tilt in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living land insectivore?",
            listOf("Giant Anteater", "Pangolin", "Aardvark", "Echidna"),
            0,
            listOf("Giant Anteaters are the largest land insectivores in the world.", "Pangolins are not known for being the largest land insectivores.", "Aardvarks are not known for being the largest land insectivores.")
        ),
        Question(
            "Which country has the most diverse marine ecosystem?",
            listOf("Australia", "Indonesia", "Philippines", "Papua New Guinea"),
            0,
            listOf("Australia has the most diverse marine ecosystem in the world.", "Indonesia has the most diverse marine ecosystem in the world.", "Philippines has the most diverse marine ecosystem in the world.")
        ),
        Question(
            "What is the name of the world's largest living land frugivore?",
            listOf("Orangutan", "Gorilla", "Chimpanzee", "Bonobo"),
            0,
            listOf("Orangutans are the largest frugivores in the world.", "Gorillas are the largest frugivores in the world.", "Chimpanzees are the largest frugivores in the world.")
        ),
        Question(
            "Which planet has the most extreme orbital period?",
            listOf("Mercury", "Venus", "Mars", "Pluto"),
            3,
            listOf("Mercury has the most extreme orbital period in the solar system.", "Venus has the most extreme orbital period in the solar system.", "Mars has the most extreme orbital period in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living land granivore?",
            listOf("Emu", "Ostrich", "Cassowary", "Rhea"),
            1,
            listOf("Emu is the largest granivore in the world.", "Ostrich is the largest granivore in the world.", "Cassowary is the largest granivore in the world.")
        ),
        Question(
            "Which country has the most natural hot springs?",
            listOf("Japan", "Iceland", "New Zealand", "United States"),
            1,
            listOf("Japan has the most natural hot springs in the world.", "Iceland has the most natural hot springs in the world.", "New Zealand has the most natural hot springs in the world.")
        ),
        Question(
            "What is the name of the world's largest living arthropod?",
            listOf("Giant Centipede", "Japanese Spider Crab", "Giant Isopod", "Giant Weta"),
            1,
            listOf("Japanese Spider Crabs are the largest living arthropods in the world.", "Giant Isopods are not known for being the largest living arthropods.", "Giant Wetas are not known for being the largest living arthropods.")
        ),
        Question(
            "Which planet has the most extreme winds?",
            listOf("Jupiter", "Saturn", "Neptune", "Uranus"),
            2,
            listOf("Jupiter has the most extreme winds in the solar system.", "Saturn has the most extreme winds in the solar system.", "Neptune has the most extreme winds in the solar system.")
        )
    )

    val level4Questions = listOf(
        Question(
            "What is the name of the world's deepest known point in the ocean?",
            listOf("Mariana Trench", "Puerto Rico Trench", "Java Trench", "Philippine Trench"),
            0,
            listOf("The Mariana Trench is the deepest point in the ocean.", "The Puerto Rico Trench is located in the Caribbean Sea.", "The Java Trench is located in the Pacific Ocean.")
        ),
        Question(
            "Which element is the most abundant in the Earth's crust?",
            listOf("Iron", "Oxygen", "Silicon", "Aluminum"),
            1,
            listOf("Iron is the most abundant element in the Earth's crust.", "Oxygen is the most abundant element in the Earth's crust.", "Silicon is the most abundant element in the Earth's crust.")
        ),
        Question(
            "What is the name of the world's largest living organism by area?",
            listOf("Great Barrier Reef", "Pando Aspen Grove", "Honey Fungus", "Giant Sequoia"),
            1,
            listOf("The Great Barrier Reef is the largest living organism by area in the world.", "Pando Aspen Grove is a small grove in Utah.", "Honey Fungus is a type of fungus.")
        ),
        Question(
            "Which country has the most active volcanoes?",
            listOf("Japan", "Indonesia", "United States", "Philippines"),
            1,
            listOf("Japan has the most active volcanoes in the world.", "Indonesia has the most active volcanoes in the world.", "The United States has the most active volcanoes in the world.")
        ),
        Question(
            "What is the name of the world's largest living land invertebrate?",
            listOf("Giant Squid", "Colossal Squid", "Giant Isopod", "Japanese Spider Crab"),
            3,
            listOf("Giant Squids are the largest living invertebrates in the world.", "Colossal Squids are not known for being the largest living invertebrates.", "Giant Isopods are not known for being the largest living invertebrates.")
        ),
        Question(
            "Which planet has the most extreme temperature difference between day and night?",
            listOf("Mercury", "Venus", "Mars", "Jupiter"),
            0,
            listOf("Mercury has the most extreme temperature difference between day and night in the solar system.", "Venus has the most extreme temperature difference between day and night in the solar system.", "Mars has the most extreme temperature difference between day and night in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living land mollusk?",
            listOf("Giant African Snail", "Giant Clam", "Giant Squid", "Colossal Squid"),
            0,
            listOf("Giant African Snails are the largest living mollusks in the world.", "Giant Clams are not known for being the largest living mollusks.", "Giant Squids are not known for being the largest living mollusks.")
        ),
        Question(
            "Which country has the most diverse bird species?",
            listOf("Colombia", "Peru", "Brazil", "Ecuador"),
            0,
            listOf("Colombia has the most diverse bird species in the world.", "Peru has the most diverse bird species in the world.", "Brazil has the most diverse bird species in the world.")
        ),
        Question(
            "What is the name of the world's largest living land arachnid?",
            listOf("Goliath Birdeater", "Huntsman Spider", "Wolf Spider", "Tarantula"),
            0,
            listOf("Goliath Birdeaters are the largest living arachnids in the world.", "Huntsman Spiders are not known for being the largest living arachnids.", "Wolf Spiders are not known for being the largest living arachnids.")
        ),
        Question(
            "Which planet has the most extreme atmospheric pressure?",
            listOf("Mercury", "Venus", "Earth", "Jupiter"),
            1,
            listOf("Mercury has the most extreme atmospheric pressure in the solar system.", "Venus has the most extreme atmospheric pressure in the solar system.", "Earth has the most extreme atmospheric pressure in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living land crustacean?",
            listOf("Coconut Crab", "Giant Isopod", "Japanese Spider Crab", "Giant Lobster"),
            0,
            listOf("Coconut Crabs are the largest living crustaceans in the world.", "Giant Isopods are not known for being the largest living crustaceans.", "Japanese Spider Crabs are not known for being the largest living crustaceans.")
        ),
        Question(
            "Which country has the most diverse mammal species?",
            listOf("Indonesia", "Brazil", "Colombia", "Peru"),
            0,
            listOf("Indonesia has the most diverse mammal species in the world.", "Brazil has the most diverse mammal species in the world.", "Colombia has the most diverse mammal species in the world.")
        ),
        Question(
            "What is the name of the world's largest living land annelid?",
            listOf("Giant Earthworm", "Giant Leech", "Giant Tube Worm", "Giant Flatworm"),
            0,
            listOf("Giant Earthworms are the largest living annelids in the world.", "Giant Leechs are not known for being the largest living annelids.", "Giant Tube Worms are not known for being the largest living annelids.")
        ),
        Question(
            "Which planet has the most extreme gravitational force at its surface?",
            listOf("Earth", "Jupiter", "Saturn", "Neptune"),
            1,
            listOf("Earth has the most extreme gravitational force at its surface in the solar system.", "Jupiter has the most extreme gravitational force at its surface in the solar system.", "Saturn has the most extreme gravitational force at its surface in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living land cnidarian?",
            listOf("Giant Jellyfish", "Giant Anemone", "Giant Coral", "Giant Sea Pen"),
            0,
            listOf("Giant Jellyfish are the largest living cnidarians in the world.", "Giant Anemones are not known for being the largest living cnidarians.", "Giant Corals are not known for being the largest living cnidarians.")
        ),
        Question(
            "Which country has the most diverse reptile species?",
            listOf("Australia", "Mexico", "Brazil", "Indonesia"),
            0,
            listOf("Australia has the most diverse reptile species in the world.", "Mexico has the most diverse reptile species in the world.", "Brazil has the most diverse reptile species in the world.")
        ),
        Question(
            "What is the name of the world's largest living land echinoderm?",
            listOf("Giant Starfish", "Giant Sea Urchin", "Giant Sea Cucumber", "Giant Brittle Star"),
            0,
            listOf("Giant Starfish are the largest living echinoderms in the world.", "Giant Sea Urchins are not known for being the largest living echinoderms.", "Giant Sea Cucumbers are not known for being the largest living echinoderms.")
        ),
        Question(
            "Which planet has the most extreme orbital speed?",
            listOf("Mercury", "Venus", "Earth", "Mars"),
            0,
            listOf("Mercury has the most extreme orbital speed in the solar system.", "Venus has the most extreme orbital speed in the solar system.", "Earth has the most extreme orbital speed in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living land chordate?",
            listOf("African Bush Elephant", "Blue Whale", "Giraffe", "Hippopotamus"),
            0,
            listOf("African Bush Elephants are the largest land chordates in the world.", "Blue Whales are the largest living chordates in the world.", "Giraffes are the tallest living chordates.")
        ),
        Question(
            "Which country has the most diverse amphibian species?",
            listOf("Brazil", "Colombia", "Peru", "Ecuador"),
            0,
            listOf("Brazil has the most diverse amphibian species in the world.", "Colombia has the most diverse amphibian species in the world.", "Peru has the most diverse amphibian species in the world.")
        ),
        Question(
            "What is the name of the world's largest living land poriferan?",
            listOf("Giant Sponge", "Giant Coral", "Giant Anemone", "Giant Jellyfish"),
            0,
            listOf("Giant Sponges are the largest living poriferans in the world.", "Giant Corals are not known for being the largest living poriferans.", "Giant Anemones are not known for being the largest living poriferans.")
        ),
        Question(
            "Which planet has the most extreme escape velocity?",
            listOf("Earth", "Jupiter", "Saturn", "Neptune"),
            1,
            listOf("Earth has the most extreme escape velocity in the solar system.", "Jupiter has the most extreme escape velocity in the solar system.", "Saturn has the most extreme escape velocity in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living land platyhelminth?",
            listOf("Giant Flatworm", "Giant Tapeworm", "Giant Fluke", "Giant Planarian"),
            0,
            listOf("Giant Flatworms are the largest living platyhelminths in the world.", "Giant Tapeworms are not known for being the largest living platyhelminths.", "Giant Flukes are not known for being the largest living platyhelminths.")
        ),
        Question(
            "Which country has the most diverse fish species?",
            listOf("Indonesia", "Brazil", "Australia", "Philippines"),
            0,
            listOf("Indonesia has the most diverse fish species in the world.", "Brazil has the most diverse fish species in the world.", "Australia has the most diverse fish species in the world.")
        ),
        Question(
            "What is the name of the world's largest living land nematode?",
            listOf("Giant Roundworm", "Giant Hookworm", "Giant Pinworm", "Giant Whipworm"),
            0,
            listOf("Giant Roundworms are the largest living nematodes in the world.", "Giant Hookworms are not known for being the largest living nematodes.", "Giant Pinworms are not known for being the largest living nematodes.")
        ),
        Question(
            "Which planet has the most extreme solar radiation exposure?",
            listOf("Mercury", "Venus", "Earth", "Mars"),
            0,
            listOf("Mercury has the most extreme solar radiation exposure in the solar system.", "Venus has the most extreme solar radiation exposure in the solar system.", "Earth has the most extreme solar radiation exposure in the solar system.")
        )
    )

    val level5Questions = listOf(
        Question(
            "What is the name of the world's largest living organism by mass?",
            listOf("Blue Whale", "Giant Sequoia", "Great Barrier Reef", "Pando Aspen Grove"),
            0,
            listOf("Blue Whales are the largest animals in the world.", "Giant Sequoias are the largest trees in the world.", "The Great Barrier Reef is the largest living organism in the world.")
        ),
        Question(
            "Which element is the most abundant in the universe?",
            listOf("Helium", "Hydrogen", "Oxygen", "Carbon"),
            1,
            listOf("Hydrogen is the most abundant element in the universe.", "Oxygen is the most abundant element in the universe.", "Carbon is the most abundant element in the universe.")
        ),
        Question(
            "What is the name of the world's largest living organism by height?",
            listOf("Hyperion", "General Sherman", "Helios", "Icarus"),
            0,
            listOf("General Sherman is the tallest living tree in the world.", "Hyperion is a tree in California.", "Helios is a tree in California.")
        ),
        Question(
            "Which country has the most diverse plant species?",
            listOf("Brazil", "Colombia", "China", "Indonesia"),
            0,
            listOf("Brazil has the most diverse plant species in the world.", "Colombia has the most diverse plant species in the world.", "China has the most diverse plant species in the world.")
        ),
        Question(
            "What is the name of the world's largest living organism by age?",
            listOf("Methuselah", "Pando", "Great Barrier Reef", "Giant Sequoia"),
            1,
            listOf("Methuselah is the oldest living organism in the world.", "Pando is a small grove in Utah.", "The Great Barrier Reef is the oldest living organism in the world.")
        ),
        Question(
            "Which planet has the most extreme magnetic field strength?",
            listOf("Earth", "Jupiter", "Saturn", "Neptune"),
            1,
            listOf("Earth has the most extreme magnetic field strength in the solar system.", "Jupiter has the most extreme magnetic field strength in the solar system.", "Saturn has the most extreme magnetic field strength in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living organism by complexity?",
            listOf("Human Brain", "Blue Whale", "Giant Sequoia", "Great Barrier Reef"),
            0,
            listOf("The human brain is the most complex organ in the human body.", "Blue Whales are the largest animals in the world.", "Giant Sequoias are the largest trees in the world.")
        ),
        Question(
            "Which country has the most diverse insect species?",
            listOf("Brazil", "Colombia", "Indonesia", "Peru"),
            0,
            listOf("Brazil has the most diverse insect species in the world.", "Colombia has the most diverse insect species in the world.", "Indonesia has the most diverse insect species in the world.")
        ),
        Question(
            "What is the name of the world's largest living organism by metabolic rate?",
            listOf("Blue Whale", "Elephant", "Giraffe", "Hippopotamus"),
            0,
            listOf("Blue Whales have the highest metabolic rate in the world.", "Elephants have the highest metabolic rate in the world.", "Giraffes have the highest metabolic rate in the world.")
        ),
        Question(
            "Which planet has the most extreme atmospheric composition?",
            listOf("Venus", "Earth", "Mars", "Jupiter"),
            0,
            listOf("Venus has the most extreme atmospheric composition in the solar system.", "Earth has the most extreme atmospheric composition in the solar system.", "Mars has the most extreme atmospheric composition in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living organism by reproductive capacity?",
            listOf("Bacteria", "Virus", "Fungus", "Plant"),
            0,
            listOf("Bacteria are the most abundant living organisms in the world.", "Viruses are not known for having reproductive capacity.", "Fungus is not known for having reproductive capacity.")
        ),
        Question(
            "Which country has the most diverse fungal species?",
            listOf("Brazil", "Colombia", "Indonesia", "Peru"),
            0,
            listOf("Brazil has the most diverse fungal species in the world.", "Colombia has the most diverse fungal species in the world.", "Indonesia has the most diverse fungal species in the world.")
        ),
        Question(
            "What is the name of the world's largest living organism by adaptability?",
            listOf("Cockroach", "Bacteria", "Tardigrade", "Virus"),
            2,
            listOf("Cockroaches are the most adaptable living organisms in the world.", "Bacteria are not known for being adaptable.", "Tardigrades are not known for being adaptable.")
        ),
        Question(
            "Which planet has the most extreme orbital inclination?",
            listOf("Mercury", "Venus", "Earth", "Pluto"),
            3,
            listOf("Mercury has the most extreme orbital inclination in the solar system.", "Venus has the most extreme orbital inclination in the solar system.", "Earth has the most extreme orbital inclination in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living organism by intelligence?",
            listOf("Human", "Dolphin", "Elephant", "Chimpanzee"),
            0,
            listOf("Humans are the most intelligent living organisms in the world.", "Dolphins are the most intelligent cetaceans.", "Elephants are the most intelligent land animals.")
        ),
        Question(
            "Which country has the most diverse microbial species?",
            listOf("Brazil", "Colombia", "Indonesia", "Peru"),
            0,
            listOf("Brazil has the most diverse microbial species in the world.", "Colombia has the most diverse microbial species in the world.", "Indonesia has the most diverse microbial species in the world.")
        ),
        Question(
            "What is the name of the world's largest living organism by social complexity?",
            listOf("Human", "Ant Colony", "Bee Hive", "Elephant Herd"),
            0,
            listOf("Humans are the most social living organisms in the world.", "Ant Colonies are not known for being social.", "Bee Hives are not known for being social.")
        ),
        Question(
            "Which planet has the most extreme tidal forces?",
            listOf("Earth", "Jupiter", "Saturn", "Neptune"),
            0,
            listOf("Earth has the most extreme tidal forces in the solar system.", "Jupiter has the most extreme tidal forces in the solar system.", "Saturn has the most extreme tidal forces in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living organism by communication ability?",
            listOf("Human", "Dolphin", "Whale", "Bird"),
            0,
            listOf("Humans are the most communicative living organisms in the world.", "Dolphins are the most communicative cetaceans.", "Whales are the most communicative cetaceans.")
        ),
        Question(
            "Which country has the most diverse viral species?",
            listOf("Brazil", "Colombia", "Indonesia", "Peru"),
            0,
            listOf("Brazil has the most diverse viral species in the world.", "Colombia has the most diverse viral species in the world.", "Indonesia has the most diverse viral species in the world.")
        ),
        Question(
            "What is the name of the world's largest living organism by learning capacity?",
            listOf("Human", "Dolphin", "Elephant", "Chimpanzee"),
            0,
            listOf("Humans are the most learning-capable living organisms in the world.", "Dolphins are the most learning-capable cetaceans.", "Elephants are the most learning-capable land animals.")
        ),
        Question(
            "Which planet has the most extreme seasonal variations?",
            listOf("Earth", "Mars", "Uranus", "Neptune"),
            2,
            listOf("Earth has the most extreme seasonal variations in the solar system.", "Mars has the most extreme seasonal variations in the solar system.", "Uranus has the most extreme seasonal variations in the solar system.")
        ),
        Question(
            "What is the name of the world's largest living organism by problem-solving ability?",
            listOf("Human", "Dolphin", "Elephant", "Chimpanzee"),
            0,
            listOf("Humans are the most problem-solving-capable living organisms in the world.", "Dolphins are the most problem-solving-capable cetaceans.", "Elephants are the most problem-solving-capable land animals.")
        ),
        Question(
            "Which country has the most diverse prion species?",
            listOf("Brazil", "Colombia", "Indonesia", "Peru"),
            0,
            listOf("Brazil has the most diverse prion species in the world.", "Colombia has the most diverse prion species in the world.", "Indonesia has the most diverse prion species in the world.")
        ),
        Question(
            "What is the name of the world's largest living organism by tool-making ability?",
            listOf("Human", "Chimpanzee", "Dolphin", "Elephant"),
            0,
            listOf("Humans are the most tool-making-capable living organisms in the world.", "Chimpanzees are not known for being tool-making-capable.", "Dolphins are not known for being tool-making-capable.")
        ),
        Question(
            "Which planet has the most extreme geological activity?",
            listOf("Earth", "Venus", "Mars", "Jupiter"),
            0,
            listOf("Earth has the most extreme geological activity in the solar system.", "Venus has the most extreme geological activity in the solar system.", "Mars has the most extreme geological activity in the solar system.")
        )
    )
} 