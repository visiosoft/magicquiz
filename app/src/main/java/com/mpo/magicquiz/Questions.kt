package com.mpo.magicquiz

data class Question(
    val question: String,
    val options: List<String>,
    val correctAnswer: Int
)

object Questions {
    val level1Questions = listOf(
        Question(
            "What is the capital of Japan?",
            listOf("Seoul", "Beijing", "Tokyo", "Bangkok"),
            2
        ),
        Question(
            "Which animal is known as the 'king of the jungle'?",
            listOf("Tiger", "Lion", "Elephant", "Gorilla"),
            1
        ),
        Question(
            "What is the main ingredient in bread?",
            listOf("Rice", "Corn", "Wheat", "Potato"),
            2
        ),
        Question(
            "How many colors are in a rainbow?",
            listOf("5", "6", "7", "8"),
            2
        ),
        Question(
            "Which planet is closest to the Sun?",
            listOf("Venus", "Mars", "Mercury", "Earth"),
            2
        ),
        Question(
            "What is the largest organ in the human body?",
            listOf("Heart", "Brain", "Liver", "Skin"),
            3
        ),
        Question(
            "How many legs does a spider have?",
            listOf("6", "8", "10", "12"),
            1
        ),
        Question(
            "What is the name of the world's largest rainforest?",
            listOf("Congo Rainforest", "Amazon Rainforest", "Borneo Rainforest", "Daintree Rainforest"),
            1
        ),
        Question(
            "Which animal can change its color to match its surroundings?",
            listOf("Frog", "Chameleon", "Snake", "Lizard"),
            1
        ),
        Question(
            "What is the main ingredient in chocolate?",
            listOf("Vanilla", "Cocoa", "Coffee", "Sugar"),
            1
        ),
        Question(
            "What is the capital of India?",
            listOf("Mumbai", "New Delhi", "Bangalore", "Kolkata"),
            1
        ),
        Question(
            "Which animal is known as the 'ship of the desert'?",
            listOf("Horse", "Camel", "Elephant", "Donkey"),
            1
        ),
        Question(
            "What is the main ingredient in pizza?",
            listOf("Cheese", "Tomato", "Flour", "Meat"),
            2
        ),
        Question(
            "Which planet is known as the 'Blue Planet'?",
            listOf("Mars", "Venus", "Earth", "Neptune"),
            2
        ),
        Question(
            "What is the name of the world's largest mountain?",
            listOf("K2", "Mount Everest", "Kangchenjunga", "Lhotse"),
            1
        ),
        Question(
            "Which fruit is known as the 'king of fruits' in Southeast Asia?",
            listOf("Mango", "Durian", "Papaya", "Pineapple"),
            1
        ),
        Question(
            "What is the name of the world's largest river?",
            listOf("Nile", "Amazon", "Yangtze", "Mississippi"),
            1
        ),
        Question(
            "Which animal is known as the 'king of the Arctic'?",
            listOf("Arctic Fox", "Polar Bear", "Walrus", "Seal"),
            1
        ),
        Question(
            "What is the name of the world's largest island?",
            listOf("Madagascar", "Greenland", "Borneo", "New Guinea"),
            1
        ),
        Question(
            "Which planet is known as the 'Morning Star'?",
            listOf("Mars", "Venus", "Mercury", "Jupiter"),
            1
        ),
        Question(
            "What is the name of the world's largest living bird?",
            listOf("Emu", "Ostrich", "Cassowary", "Albatross"),
            1
        ),
        Question(
            "Which animal is known as the 'king of the savanna'?",
            listOf("Tiger", "Lion", "Elephant", "Giraffe"),
            1
        ),
        Question(
            "What is the name of the world's largest living reptile?",
            listOf("Komodo Dragon", "Saltwater Crocodile", "Green Anaconda", "Leatherback Turtle"),
            1
        ),
        Question(
            "Which planet is known as the 'Red Planet'?",
            listOf("Venus", "Mars", "Jupiter", "Saturn"),
            1
        ),
        Question(
            "What is the name of the world's largest living fish?",
            listOf("Blue Whale", "Whale Shark", "Great White Shark", "Manta Ray"),
            1
        )
    )

    val level2Questions = listOf(
        Question(
            "Which country has the most natural lakes?",
            listOf("United States", "Canada", "Russia", "Finland"),
            1
        ),
        Question(
            "What is the largest bone in the human body?",
            listOf("Skull", "Femur", "Spine", "Pelvis"),
            1
        ),
        Question(
            "Which planet has the most moons?",
            listOf("Jupiter", "Saturn", "Uranus", "Neptune"),
            1
        ),
        Question(
            "What is the name of the world's largest coral reef system?",
            listOf("Great Barrier Reef", "Belize Barrier Reef", "New Caledonia Barrier Reef", "Red Sea Coral Reef"),
            0
        ),
        Question(
            "Which element has the chemical symbol 'Au'?",
            listOf("Silver", "Gold", "Copper", "Aluminum"),
            1
        ),
        Question(
            "What is the name of the world's largest waterfall?",
            listOf("Victoria Falls", "Angel Falls", "Niagara Falls", "Iguazu Falls"),
            1
        ),
        Question(
            "Which country has the most time zones?",
            listOf("United States", "Russia", "France", "United Kingdom"),
            2
        ),
        Question(
            "What is the name of the world's largest living organism?",
            listOf("Blue Whale", "Giant Sequoia", "Great Barrier Reef", "Pando Aspen Grove"),
            3
        ),
        Question(
            "Which planet has the longest day?",
            listOf("Mercury", "Venus", "Mars", "Jupiter"),
            1
        ),
        Question(
            "What is the name of the world's largest volcano?",
            listOf("Mount Everest", "Mauna Loa", "Mount Kilimanjaro", "Mount Fuji"),
            1
        ),
        Question(
            "Which animal has the longest lifespan?",
            listOf("Elephant", "Tortoise", "Bowhead Whale", "Greenland Shark"),
            3
        ),
        Question(
            "What is the name of the world's largest canyon?",
            listOf("Grand Canyon", "Yarlung Tsangpo Canyon", "Kali Gandaki Gorge", "Cotahuasi Canyon"),
            1
        ),
        Question(
            "Which country has the most islands?",
            listOf("Indonesia", "Sweden", "Finland", "Norway"),
            1
        ),
        Question(
            "What is the name of the world's largest living fish?",
            listOf("Blue Whale", "Whale Shark", "Great White Shark", "Manta Ray"),
            1
        ),
        Question(
            "Which planet has the most rings?",
            listOf("Jupiter", "Saturn", "Uranus", "Neptune"),
            1
        ),
        Question(
            "What is the name of the world's largest desert?",
            listOf("Sahara Desert", "Antarctic Desert", "Arctic Desert", "Gobi Desert"),
            1
        ),
        Question(
            "Which animal has the strongest bite force?",
            listOf("Lion", "Tiger", "Saltwater Crocodile", "Great White Shark"),
            2
        ),
        Question(
            "What is the name of the world's largest living bird?",
            listOf("Emu", "Ostrich", "Cassowary", "Albatross"),
            1
        ),
        Question(
            "Which country has the most active volcanoes?",
            listOf("Japan", "Indonesia", "United States", "Philippines"),
            1
        ),
        Question(
            "What is the name of the world's largest living reptile?",
            listOf("Komodo Dragon", "Saltwater Crocodile", "Green Anaconda", "Leatherback Turtle"),
            1
        ),
        Question(
            "Which planet has the most extreme temperature variations?",
            listOf("Mercury", "Venus", "Mars", "Jupiter"),
            0
        ),
        Question(
            "What is the name of the world's largest living amphibian?",
            listOf("Giant Salamander", "Bullfrog", "Axolotl", "Cane Toad"),
            0
        ),
        Question(
            "Which country has the most natural hot springs?",
            listOf("Japan", "Iceland", "New Zealand", "United States"),
            1
        ),
        Question(
            "What is the name of the world's largest living single-celled organism?",
            listOf("Amoeba", "Paramecium", "Valonia ventricosa", "Stentor"),
            2
        ),
        Question(
            "Which planet has the most extreme pressure at its surface?",
            listOf("Mercury", "Venus", "Mars", "Jupiter"),
            1
        )
    )

    val level3Questions = listOf(
        Question(
            "What is the name of the world's largest living single-celled organism?",
            listOf("Amoeba", "Paramecium", "Valonia ventricosa", "Stentor"),
            2
        ),
        Question(
            "Which country has the most UNESCO World Heritage Sites?",
            listOf("China", "Italy", "Spain", "France"),
            1
        ),
        Question(
            "What is the name of the world's largest living tree by volume?",
            listOf("Hyperion", "General Sherman", "Helios", "Icarus"),
            1
        ),
        Question(
            "Which planet has the most extreme pressure at its surface?",
            listOf("Mercury", "Venus", "Mars", "Jupiter"),
            1
        ),
        Question(
            "What is the name of the world's largest living land animal?",
            listOf("African Bush Elephant", "Asian Elephant", "Giraffe", "Hippopotamus"),
            0
        ),
        Question(
            "Which country has the most natural resources?",
            listOf("United States", "Russia", "China", "Australia"),
            1
        ),
        Question(
            "What is the name of the world's largest living primate?",
            listOf("Gorilla", "Orangutan", "Chimpanzee", "Bonobo"),
            0
        ),
        Question(
            "Which planet has the most extreme magnetic field?",
            listOf("Earth", "Jupiter", "Saturn", "Neptune"),
            1
        ),
        Question(
            "What is the name of the world's largest living marsupial?",
            listOf("Kangaroo", "Koala", "Tasmanian Devil", "Wombat"),
            0
        ),
        Question(
            "Which country has the most diverse ecosystem?",
            listOf("Brazil", "Indonesia", "Colombia", "Peru"),
            2
        ),
        Question(
            "What is the name of the world's largest living rodent?",
            listOf("Beaver", "Capybara", "Porcupine", "Nutria"),
            1
        ),
        Question(
            "Which planet has the most extreme seasons?",
            listOf("Earth", "Mars", "Uranus", "Neptune"),
            2
        ),
        Question(
            "What is the name of the world's largest living carnivorous marsupial?",
            listOf("Tasmanian Devil", "Quoll", "Numbat", "Bilby"),
            0
        ),
        Question(
            "Which country has the most endemic species?",
            listOf("Australia", "Madagascar", "Brazil", "Indonesia"),
            1
        ),
        Question(
            "What is the name of the world's largest living land carnivore?",
            listOf("Polar Bear", "Brown Bear", "Tiger", "Lion"),
            0
        ),
        Question(
            "Which planet has the most extreme orbital eccentricity?",
            listOf("Mercury", "Venus", "Mars", "Pluto"),
            3
        ),
        Question(
            "What is the name of the world's largest living land herbivore?",
            listOf("African Bush Elephant", "Asian Elephant", "Giraffe", "Hippopotamus"),
            0
        ),
        Question(
            "Which country has the most diverse climate zones?",
            listOf("United States", "Russia", "China", "India"),
            1
        ),
        Question(
            "What is the name of the world's largest living land omnivore?",
            listOf("Brown Bear", "Polar Bear", "Grizzly Bear", "Black Bear"),
            0
        ),
        Question(
            "Which planet has the most extreme axial tilt?",
            listOf("Earth", "Mars", "Uranus", "Neptune"),
            2
        ),
        Question(
            "What is the name of the world's largest living land insectivore?",
            listOf("Giant Anteater", "Pangolin", "Aardvark", "Echidna"),
            0
        ),
        Question(
            "Which country has the most diverse marine ecosystem?",
            listOf("Australia", "Indonesia", "Philippines", "Papua New Guinea"),
            0
        ),
        Question(
            "What is the name of the world's largest living land frugivore?",
            listOf("Orangutan", "Gorilla", "Chimpanzee", "Bonobo"),
            0
        ),
        Question(
            "Which planet has the most extreme orbital period?",
            listOf("Mercury", "Venus", "Mars", "Pluto"),
            3
        ),
        Question(
            "What is the name of the world's largest living land granivore?",
            listOf("Emu", "Ostrich", "Cassowary", "Rhea"),
            1
        ),
        Question(
            "Which country has the most natural hot springs?",
            listOf("Japan", "Iceland", "New Zealand", "United States"),
            1
        ),
        Question(
            "What is the name of the world's largest living arthropod?",
            listOf("Giant Centipede", "Japanese Spider Crab", "Giant Isopod", "Giant Weta"),
            1
        ),
        Question(
            "Which planet has the most extreme winds?",
            listOf("Jupiter", "Saturn", "Neptune", "Uranus"),
            2
        )
    )
} 