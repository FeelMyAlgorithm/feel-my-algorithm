const readline = require("readline");
const line = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
let input = [];
let arr, answer;
line
  .on("line", (li) => input.push(li))
  .on("close", () => {
    input.map((li, idx) => {
      if (idx === 0) {
        const num = parseInt(li);
        arr = Array.from({ length: num }, () =>
          Array.from({ length: num }, () => 0)
        );
      } else {
        li.split(" ").forEach((item, i) => {
          if (idx === 1) {
            arr[idx - 1][i] = parseInt(item);
          } else if (i === 0) {
            arr[idx - 1][i] = parseInt(item) + arr[idx - 2][i];
          } else if (i === idx - 1) {
            arr[idx - 1][i] = parseInt(item) + arr[idx - 2][i - 1];
          } else {
            arr[idx - 1][i] =
              parseInt(item) + Math.max(arr[idx - 2][i - 1], arr[idx - 2][i]);
          }
        });
      }
      answer = Math.max(...arr[arr.length - 1]);
    });

    console.log(answer);
    process.exit(0);
  });
