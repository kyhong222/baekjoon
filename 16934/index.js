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

inputs = ["backjoon", "startlink", "bakejoon", "beakjoon", "baekjoon"];

for (let i = 0; i < inputs.length; i++) {
  console.log(makePrefix(inputs[i]));
}

function checkExist(prefix) {
  const checker = nicknames.map((element) => element.indexOf(prefix));
  if (checker.includes(0)) {
    return true;
  }
  return false;
}
