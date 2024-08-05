function add(a, b=1) {
    console.log("a = "+a);
    console.log("b = "+b);
    const c = a+b;
    console.log("Sum: "+c);
}

add(20);
add(20,60);