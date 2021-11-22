function bubbleSort(arr) {
  for (let i = arr.length - 1; i > 0; i--) {
    for (let j = 0; j < i; j++) {
      if (arr[j] > arr[j + 1]) {
        let temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
      }
    }
  }
  return arr;
}

function test() {
  let given = [13, 5, 11, 7, 23, 15];
  bubbleSort(given);
  console.log(given);
  let expect = [5, 7, 11, 13, 15, 23];
  console.log(JSON.stringify(given) == JSON.stringify(expect));
}

test();
