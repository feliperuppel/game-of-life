
# Game of Life

#### Definition

The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells, each of
which is in one of two possible states, alive or dead. Every cell interacts with its eight neighbors, which
are the cells that are horizontally, vertically, or diagonally adjacent.

#### Rules

At each step in time, the following transitions occur:
- Any live cell with fewer than two live neighbors dies as if caused by underpopulation.
- Any live cell with two or three live neighbors lives on to the next generation.
- Any live cell with more than three live neighbors dies, as if by overcrowding.
- Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

The initial pattern constitutes the seed of the system. The first generation is created by applying the
above rules simultaneously to every cell in the seed—births and deaths occur simultaneously, and the
discrete moment at which this happens is sometimes called a tick (in other words, each generation is a
pure function of the preceding one). The rules continue to be applied repeatedly to create further
generations. 

Read more [here](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)

#### Implementation

This is a simple implementation of the game mechanics.
There are three basic classes.

 * GameOfLife.java is the trigger for the game, it expects the initial seed of life and for how many generations it should play.
 * Universe.java is a placeholder for all the live cells. It is infinite but also immutable. At each generation a new Universe is created with new Life positions.
 * Rules.java knows all the game rules, and can decide if a cell should live or die.

There is a Main class that triggers the algorithm using the [Glider Pattern](https://en.wikipedia.org/wiki/Glider_(Conway%27s_Life)) and 10 generations.
As for now there is no UI of any kind. But the universe is printed out at each generation, so we can check the game evolution in each step.
## Tech Stack

- Java 8
- Gradle - (Gradle Wrapper is included in the source)
- This was developed using [TDD](http://agiledata.org/essays/tdd.html), which leads to a very high code coverage during tests


## Build & Run

Clone the project

```bash
  git clone https://github.com/feliperuppel/game-of-life.git
```

Go to the project directory

```bash
  cd game-of-life
```

Build

```bash
  ./gradlew clean build
```

Run

```bash
    java -jar build/libs/game-of-life-1.0-SNAPSHOT.jar
```
## Running Tests

To run tests, run the following command

```bash
  ./gradlew test
```


## 🚀 About Me
I am passionate about technology and love learning new things. I'm a Linux enthusiast with 10+
years of experience dealing with coding. Most of it was in Java.
You can find more about me at [feliperuppel.com](https://feliperuppel.com/) or on my [LinkedIn profile](https://www.linkedin.com/in/feliperuppel/)

