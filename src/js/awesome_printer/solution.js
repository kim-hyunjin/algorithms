function solution(priorities, location) {
  var answer = 0;
  priorities = priorities.map((doc, index) => {
    return {
      priority: doc,
      location: index,
    };
  });
  console.log(priorities);

  while (priorities.length) {
    const doc = priorities.shift();
    console.log("doc: ", doc);
    if (priorities.findIndex((item) => item.priority > doc.priority) != -1) {
      priorities.push(doc);
    } else {
      answer++;
      if (doc.location === location) {
        break;
      }
    }
    console.log(answer);
    console.log("priorities : ", priorities);
  }
  return answer;
}

function main() {
  const priorities = [2, 1, 3, 2];
  const location = 2;
  console.log(solution(priorities, location));
}

main();
