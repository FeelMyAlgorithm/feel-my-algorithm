const readline = require("readline");
const line = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
let input = [];
let n, m, k;
let a, b, c;
let numbers = [];
line
  .on("line", (li) => input.push(li))
  .on("close", () => {
    for (let i = 0; i < input.length; i++) {
      if (i == 0) {
        [n, m, k] = input[0].split(" ").map((el) => parseInt(el));
      } else if (i < n + 1) {
        numbers.push(parseInt(input[i]));
      }
      if (i >= n + 1) {
        [a, b, c] = input[i].split(" ").map((el) => parseInt(el));
        if (a == 1) {
          // b번째 수를 c로 바꿈
          numbers[b - 1] = c;
        } else {
          //b번째 수부터 c번째 수까지의 합을 구하여 출력하면 됨
          console.log(
            numbers.slice(b - 1, c).reduce((acc, cur) => (acc += cur))
          );
        }
      }
    }
    process.exit(0);
  });
