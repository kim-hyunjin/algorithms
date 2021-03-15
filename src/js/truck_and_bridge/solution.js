function solution(bridge_length, weight, truck_weights) {
  var answer = 0; // 총 걸린 시간
  const trucks = truck_weights.slice();
  const passed = [];
  const bridge = [];
  for (let i = 0; i < bridge_length; i++) {
    bridge[i] = 0;
  }
  for (;;) {
    answer += 1;
    let passedTruck = bridge.shift();
    bridge[bridge_length - 1] = 0;
    if (passedTruck != 0) {
      passed.push(passedTruck);
    }

    let truck = trucks.shift();
    if (truck) {
      let bridgeWeight = bridge.reduce((acc, cur) => acc + cur, 0);
      if (bridgeWeight + truck <= weight) {
        bridge[bridge_length - 1] = truck;
      } else {
        trucks.unshift(truck);
      }
    }

    if (passed.length == truck_weights.length) {
      break;
    }
  }

  return answer;
}

function main() {
  console.log(solution(2, 10, [7, 4, 5, 6]));
}
main();
