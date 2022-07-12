const stack = [];
let top = 0;
let answer = "";

const commands = {
  push: (x) => (stack[top++] = x),
  pop: () => {
    if (top) {
      top--;
      return stack.splice(-1);
    } else return -1;
  },
  size: () => top,
  empty: () => (!top ? 1 : 0),
  top: () => (top ? stack[top - 1] : -1),
};

const readline = require("readline");
const line = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
let input = [];

line
  .on("line", (li) => input.push(li))
  .on("close", () => {
    input.map((li, idx) => {
      if (idx === 0) return;
      const [cmd, num] = li.split(" ");
      if (cmd === "push") {
        commands[cmd](parseInt(num));
      } else answer += `${commands[cmd]()}\n`;
    });

    console.log(answer);
    process.exit();
  });
