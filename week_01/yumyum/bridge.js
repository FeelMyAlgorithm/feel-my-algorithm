const [n, ...arr] = require('fs').readFileSync('/dev/stdin').toString().split("\n");

let input = [];
arr.forEach(el => {
    input.push(el.split(" "));
});

console.log(input);