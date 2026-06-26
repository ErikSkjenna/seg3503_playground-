# SEG3503 Lab 04 - Test-Driven Development

## Student

Name: Erik Skjenna
Student number: 300273106

## Project

This lab was completed using the Tic project. The objective was to practise Test-Driven Development by following the RED, GREEN, REFACTOR cycle.

## TDD Commit Groups

| Commit                                                                                                  | Type     | Description                                                  | JUnit Result        |
| ------------------------------------------------------------------------------------------------------- | -------- | ------------------------------------------------------------ | ------------------- |
| 1 <a href="images/commit1.png"><img src="images/commit1.png" alt="Commit 1 screenshot" width="120"></a> | RED      | Added equality tests for two new Tic boards                  | 3 tests, 2 failures |
| 2 <a href="images/commit2.png"><img src="images/commit2.png" alt="Commit 2 screenshot" width="120"></a> | GREEN    | Implemented equals() and hashCode()                          | 3 tests passing     |
| 3 <a href="images/commit3.png"><img src="images/commit3.png" alt="Commit 3 screenshot" width="120"></a> | RED      | Added a failing test for board display using toString()      | 4 tests, 1 failure  |
| 4 <a href="images/commit4.png"><img src="images/commit4.png" alt="Commit 4 screenshot" width="120"></a> | GREEN    | Implemented toString() to display the board as a grid        | 4 tests passing     |
| 5 <a href="images/commit5.png"><img src="images/commit5.png" alt="Commit 5 screenshot" width="120"></a> | REFACTOR | Cleaned constructor logic using constants and helper methods | 4 tests passing     |

## Summary

During this lab, I followed the TDD cycle by first writing failing tests, then writing the minimum code necessary to make the tests pass, and finally refactoring the code while keeping all tests successful.
