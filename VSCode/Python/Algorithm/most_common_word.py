import re
import collections

def most_common_word(paragraph, banned):
    words = [word for word in re.sub(r'[^\w]', ' ', paragraph)
                                .lower().split()
                                if word not in banned]

    # counts = collections.defaultdict(int)
    # for word in words:
    #     counts[word] += 1
    # return max(counts, key=counts.get)
    counts = collections.Counter(words)
    return counts.most_common(1)[0][0]
    
if __name__ == "__main__":
    paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    banned = ["hit"]

    print(most_common_word(paragraph, banned))