package com.shashtra.algorithm;

/**
 * Rabin Karp algorithm is based on matching the hash, and based on the fact that if two string are
 * same, their hash would be same but not vice versa. As, two string can have same hash value due to
 * hash collision. To calculate the hash value we can use hash[i] = hash[i-1] + ( c - 'a' + 1)*
 * pow(prime, i) % mod where prime is a prime integer and mod is big prime value to avoid frequent
 * collision in general we can go with 10^9+9 as it would reduce the probability to 1/mod
 */
public class RabinKarpSubstringMatch {

}
