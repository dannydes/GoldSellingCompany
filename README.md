# Mock exam question

1.
A Maltese company sells gold both locally and abroad in the following countries:
UK, Switzerland, Canada, Australia, and Japan.
The company ag
ents, at a time of sale, have to ask for a current price of gold (per
1gram
)
which varies several times daily due to the competition on wholesale market.
Its local agents are connected to the server on Intranet, whereas the foreign ones
connect remotely, u
sing TCP/IP.
The server maintains
the following
table with country codes and current gold prices
in
the
ir particular
currencies
.

E.g.:
Malta
UK
Swiss
CAD
AUD
JPY
24.61
22.15
36.51
37.22
40.12
3251.63

To get efficient functionality, the company decide
d to implement the server as
a
multiprotocol iterative server with two protocols TCP and UDP.
a)
Design and implement
a
multi
-
protocol
server (with service port no 1045 and 1046
for TCP and UDP protocols respectively) which, after accepting client request as
a
string specifying
a
country code, will return
the
current price to the client. The
server should store the table as an appropriate array. Consult the appendix for the
socket function enabling to identify the type of protocol
[10 marks]
