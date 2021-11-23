# iot_algo_labs

# Knuth–Morris–Pratt Algorithm

---

The Knuth–Morris–Pratt string searching algorithm (or KMP algorithm) searches for occurrences of a "word" `W` within a main "text string" `T` by employing the observation that when a mismatch occurs, the word itself embodies sufficient information to determine where the next match could begin, thus bypassing re-examination of previously matched characters.

---

## Complexity
   + Time: `O(|W| + |T|)`
   + Space: `O(|W|)`

## References
   + [Wikipedia](https://en.wikipedia.org/wiki/Knuth–Morris–Pratt_algorithm)
