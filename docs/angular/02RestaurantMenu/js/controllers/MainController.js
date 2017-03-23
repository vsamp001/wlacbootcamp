app.controller('MainController', ['$scope', function($scope) {
  $scope.today = new Date();

  $scope.appetizers = [
    {
      name: 'Caprese',
      description: 'Mozzarella, tomatoes, basil, balsmaic glaze.',
      price: 4.95
    },
    {
      name: 'Mozzarella Sticks',
      description: 'Served with marinara sauce.',
      price: 3.95
    },
    {
      name: 'Bruschetta',
      description: 'Grilled bread, garlic, tomatoes, olive oil.',
      price: 4.95
    }
  ];
  
  $scope.mains = [
    {
      name: 'Double Cheese',
      description: 'Extra cheese on cheese',
      price: 9.95
    },
    {
      name: 'Meat Lovers',
      description: 'Pepperoni, Italian sausage, mild sausage, beef topping, ham, bacon crumble and pizza mozzarella',
      price: 12.95
    },
    {
      name: 'Vegetarian',
      description: 'Kalamata olives, fetta, diced tomato, mushrooms, red & green capsicum, onion, garlic, mozzarella on a tomato sauce.',
      price: 10.95
    },
    ];
    
      $scope.sides = [
    {
      name: 'BreadSticks',
      description: 'Served with marinara sause.',
      price: 4.95
    },
    {
      name: 'Soup of the day',
      description: 'Take a chance.',
      price: 4.95
    },
    {
      name: 'Salad',
      description: 'Greens, diced tomato, and balsamic vinagrette.',
      price: 4.95
    },
    ];

}]);