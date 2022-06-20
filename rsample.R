scores <- read.csv("http://data-analytics.zybooks.com/ExamScores.csv")

exam_num <- 1

exam_mean <- sapply(scores, mean)

exam_median <- median(scores[,exam_num])

print(c("The mean is ", exam_mean[exam_num], " The median is ", exam_median[exam_num]))
      
count <- table(scores[,exam_num])
barplot(count)
