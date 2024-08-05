function sum(a,...b) {
    let sum = a;
    for(let i=0;i<b.length;i++) {
        sum = sum + b[i];
    }    
    console.log("sum : "+sum);
}

sum(10);
sum(10,20);
sum(10,20,30);
sum(10,20,30,40);

