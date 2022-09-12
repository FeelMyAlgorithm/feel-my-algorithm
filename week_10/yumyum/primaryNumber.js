const readline = require("readline");
const line = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let number;
let sum = [0, 2];
let answer = 0;
let l = 0;
let r = 1;
function isPrime(i) {
  if ((i !== 2 && i % 2 === 0) || i < 2) return false;
  let flag = true;
  for (let j = 2; j <= Math.sqrt(i); j++) {
    if (i % j === 0) {
      flag = false;
      break;
    }
  }
  return flag;
}

function getPrimeNumbers(number, primeNumbers) {
  let prev = 2;
  for (let i = 3; i <= number; i++) {
    let flag = isPrime(i);
    if (flag) {
      prev += i;
      primeNumbers.push(prev);
      if (prev <= number) r++;
    }
  }
}

line
  .on("line", (li) => (number = parseInt(li)))
  .on("close", () => {
    getPrimeNumbers(number, sum);

    while (r <= sum.length - 1) {
      if (sum[r] - sum[l] === number) {
        answer++;
      }
      if (sum[r] - sum[l] <= number) r++;
      if (sum[r] - sum[l] > number) l++;
    }

    console.log(answer);
    process.exit(0);
  });
