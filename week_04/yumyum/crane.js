function solution(board, moves) {
  let answer = 0;
  let stacks = [];
  for (let col = 0; col < board.length; col++) {
    let stack = [];
    for (let row = board.length - 1; row >= 0; row--) {
      if (board[row][col] === 0) break;
      stack.push(board[row][col]);
    }
    stacks.push(stack);
  }
  let popedStack = [];
  let top = 0;
  moves.forEach((move) => {
    if (stacks[move - 1].length > 0) {
      let popedItem = stacks[move - 1].pop();
      console.log(move - 1, popedItem);
      if (top === popedItem) {
        popedStack.pop();
        top = popedStack.length === 0 ? 0 : popedStack[popedStack.length - 1];
        answer += 2;
      } else {
        top = popedItem;
        popedStack.push(top);
      }
    }
  });

  return answer;
}
