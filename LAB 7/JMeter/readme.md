Settings:

    Number of Threads (users): 1500
    Ramp-up period (seconds): 15
    Loop Count: 1

Targets: 

    onet.pl
    wp.pl


![Alt text](image.png)


![Alt text](image-1.png)


![Alt text](image-2.png)


![Alt text](image-3.png)


![Alt text](image-4.png)


![Alt text](image-5.png)


![Alt text](image-6.png)


Report results:


    Average:
        onet.pl: 1247 ms (response time)
        wp.pl: 2547 ms (response time)
    Median:
        onet.pl: 463 ms (response time)
        wp.pl: 2406 ms (response time)
    90% Line:
        onet.pl: 90% of responses in less than 2690 ms
        wp.pl: 90% of responses in less than 3421 ms
    95% Line:
        onet.pl: 95% of responses in less than 2819 ms
        wp.pl: 95% of responses in less than 7512 ms
    99% Line:
        onet.pl: 99% of responses in less than 8134 ms
        wp.pl: 99% of responses in less than 8386 ms
    Min/Max:
        onet.pl: shortest response: 310ms, longest: 9705
        wp.pl: shortest response: 459ms, longest: 16252
    Error %:
        onet.pl: no errors
        wp.pl: no errors:
    Throughput:
        onet.pl: 8.2 requests per second
        wp.pl: 49.8 requests per second
    Received KB/sec:
        onet.pl: 3167.91
        wp.pl: 31417.75
    Sent KB/sec:
        onet.pl: 1.78
        wp.pl: 10.61

Summary:

    onet.pl has much faster response time, however both sites can have much slower response time for some users (99% line)
    The lack of errors in both tests indicates that both sites were able to handle the submitted requests during the test.
    wp.pl sens much more data in response, almost 10 times more than onet.pl
    Overall, onet.pl has much better responses time, but the wp.pl handles almost 10 time bigger data transfer

