let fs = require("fs");
// let input = fs.readFileSync("/dev/stdin").toString().split("\n");
let input = 

let count = input[0];
let numbers = [];

for (let i = 1; i < input.length; i++) {
  if (input[i] !== "") {
    numbers.push(input[i].split(" "));
  }
}

for (let i = 0; i < numbers.length; i++) {
  let num1 = Number(numbers[i][0]);
  let num2 = Number(numbers[i][1]);

  console.log(num1 + num2);
}

let prefixes = [];
let nicknames = [];

function makePrefix(nickname) {
  let prefix = "";
  for (let i = 0; i < nickname.length; i++) {
    prefix += nickname[i];
    if (isExist(prefix)) {
      continue;
    }
    if (checkExist(prefix)) {
      continue;
    }
    prefixes.push(prefix);
    nicknames.push(nickname);
    return prefix;
  }

  // nickname === prefix
  let count = nicknames.filter((item) => item === nickname).length;
  if (count) {
    prefix += parseInt(count);
  }

  prefixes.push(prefix);
  nicknames.push(nickname);
  return prefix;
}

function isExist(prefix) {
  return prefixes.includes(prefix);
}

// inputs = [
//   "codeplus",
//   "startlink",
//   "beakjoon",
//   "baek",
//   "baekjoon",
//   "baek",
//   "codingwiki",
// ];

for (let i = 0; i < input.length; i++) {
  console.log(makePrefix(input[i]));
}

function checkExist(prefix) {
  // console.log("checkExist");
  const checker = nicknames.map((element) => element.indexOf(prefix));
  // console.log(nicknames);
  // console.log(prefix);
  // console.log(checker);
  if (checker.includes(0)) {
    return true;
  }
  return false;
}
