var generateParenthesis = function (n) {
  let answer = [];
  function findAll(cur, check, cnt) {
    if (cnt == 2 * n) {
      if (check === 0) answer.push(cur);
      return;
    }

    if (check - 1 >= -1 || cnt == 0) {
      findAll(cur + ")", check - 1, cnt + 1);
      findAll(cur + "(", check + 1, cnt + 1);
    }
  }

  findAll("", 0, 0);

  return answer;
};
