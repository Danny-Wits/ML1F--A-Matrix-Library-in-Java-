# A matrix library written in Java

> Salient Features
>
> 1.  Contained in One File
>
> 2.  No external dependency
## Installation 
> Just Download and paste the Matrix.java File
## Overview

The `Matrix` class is a generic Java implementation for handling two-dimensional matrices of numeric types. It provides various functionalities, including basic operations like addition, subtraction, multiplication, and transposition. The class is designed to support any subclass of `Number`, such as `Integer`, `Double`, `Float`, and `Long`.

## Features

- Create matrices from two-dimensional arrays, one-dimensional arrays, or specify dimensions with a default value.
- Retrieve and set values in the matrix.
- Perform matrix addition, subtraction, multiplication, and transposition.
- Flatten the matrix into a one-dimensional array.
- Map and reduce operations on matrix elements.
- Support for matrix cloning.

## Installation

To use the `Matrix` class, simply include it in your Java project. Ensure that your Java environment is set up to compile and run Java code.

## Usage

### Creating a Matrix

## Matrix Operations

The `Matrix` class provides a comprehensive set of operations for matrix manipulation, including addition and subtraction of matrices as well as constants, multiplication of matrices and constants, and transposition. Users can add rows to an existing matrix, flatten a two-dimensional matrix into a one-dimensional array, and apply mapping functions to each element. The class also supports reducing a matrix to a single value using a binary function. Accessing and modifying specific elements is straightforward with methods to retrieve and set values at specified positions. This enables efficient handling of numerical computations in various applications.

### Example

```java
// Creating a matrix from a 2D array
Integer[][] array = {{1, 2}, {3, 4}};
Matrix<Integer> matrix1 = new Matrix<>(array);

// Creating a matrix from a 1D array
Integer[] array1D = {1, 2, 3};
Matrix<Integer> matrix2 = new Matrix<>(array1D);

// Creating a matrix with specific dimensions and a default value
Matrix<Integer> matrix3 = new Matrix<>(2, 3, 0); // 2 rows, 3 columns, filled with 0
```
