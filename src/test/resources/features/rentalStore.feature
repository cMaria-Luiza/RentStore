Feature: Movie Rental Store
    
	Scenario: It should not rent with no units in the inventory
		Given There are 0 units in the inventory
		When I rent
		Then It is not possible because there is no units left
		And There will be 0 units in the inventory
		
	Scenario Outline: I should give condition according to rental type
		Given There are 2 units in the inventory
	  And It costs $<price> to rent
	  And The rental type is <type>
	  When I rent
	  Then The movie has cost $<value> to rent
	  And The due date will be in <days> days
	  And There will be 1 units in the inventory
	  And The score received will be <score> points
	  
	Examples:
		|	price	|			type			|	value	|	days	|	score	|
		|		4		|		"regular"		|		4		|		1		|		1		|
		|		3		|		"extended"	|		6		|		3		|		2		|
		|	  7		|		"weekly"  	|	 21		|		7		|		3		|
	
