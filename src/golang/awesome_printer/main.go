package main

import (
	"fmt"
)

func main() {
	priorities := []int{2, 1, 3, 2}
	location := 2
	answer := solution(priorities, location)
	fmt.Println(answer)
}


