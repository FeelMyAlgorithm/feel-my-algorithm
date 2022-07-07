const fs = require("fs");
// const input = fs.readFileSync("/dev/stdin").toString().split(" ");
const [n, ...arr] = fs
	.readFileSync("./input.txt")
	.toString()
	.trim()
	.split("\r\n");

const input = arr.map((el) => el.split(" ").map((str) => parseInt(str)));

for (let i = 0; i < n; i++) {
	if (input[i][0] <= input[i][1]) {
		console.log(comb(input[i][1], input[i][0]));
	} else {
		console.log(comb(input[i][0], input[i][1]));
	}
}

function comb(a, b) {
	let number = 1;
	let divide = 1;
	for (let i = 0; i < b; i++) {
		number = number * (a - i);
		divide = divide * (b - i);
	}
	return number / divide;
}
