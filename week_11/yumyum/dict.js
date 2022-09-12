const readline = require("readline");
const line = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];
let n, m, k;
let arr = [];
line
  .on("line", (li) => (input = li.split(" ").map((el) => parseInt(el))))
  .on("close", () => {
    [n, m, k] = input;

    findAll("", 0, 0);
    if (k > fact(n + m, m) / fact(m, 0)) console.log(-1);
    else console.log(arr[k - 1]);
    process.exit(0);
  });

function findAll(cur, aCount, zCount) {
  if (aCount == n && zCount == m) {
    arr.push(cur);
    return;
  }
  if (aCount < n) {
    findAll(cur + "a", aCount + 1, zCount);
  }
  if (zCount < m) {
    findAll(cur + "z", aCount, zCount + 1);
  }
}

function fact(n, k) {
  let acc = 1;
  let cnt = n - k;
  let cur = n;
  if (k == 0) return acc;
  while (cnt > 0) {
    acc *= cur;
    cur--;
    cnt--;
  }
  return acc;
}
