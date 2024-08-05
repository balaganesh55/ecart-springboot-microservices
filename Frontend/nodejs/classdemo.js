class Customer {
   
    // constructor() {
    //     this.id = 0;
    //     this.name = '';
    //     this.age = 0;
    // }

    constructor(id,name,age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    display() {
        console.log("id = "+this.id);
        console.log("name = "+this.name);
        console.log("age = "+this.age);
    }
}

// const c1 = new Customer();
// c1.id = 101;
// c1.name = "rohit";
// c1.age = 25;

// console.log("Id: "+c1.id);
// console.log("Name: "+c1.name);
// console.log("Age: "+c1.age);

const c2 = new Customer(102,'ram',30);
// console.log("Id: "+c2.id);
// console.log("Name: "+c2.name);
// console.log("Age: "+c2.age);
c2.display();

