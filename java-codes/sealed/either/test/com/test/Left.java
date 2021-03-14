package com.test;

public record Left(String error, String tag) implements EitherLeftOrRight{}
