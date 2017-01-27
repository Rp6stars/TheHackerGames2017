--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.10
-- Dumped by pg_dump version 9.6.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: hackers2017; Type: SCHEMA; Schema: -; Owner: irznfnkrlxvtzj
--

CREATE SCHEMA hackers2017;


ALTER SCHEMA hackers2017 OWNER TO irznfnkrlxvtzj;

SET search_path = hackers2017, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: body_part; Type: TABLE; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

CREATE TABLE body_part (
    id integer NOT NULL,
    name character varying(50)
);


ALTER TABLE body_part OWNER TO irznfnkrlxvtzj;

--
-- Name: body_part_id_seq; Type: SEQUENCE; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

CREATE SEQUENCE body_part_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE body_part_id_seq OWNER TO irznfnkrlxvtzj;

--
-- Name: body_part_id_seq; Type: SEQUENCE OWNED BY; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER SEQUENCE body_part_id_seq OWNED BY body_part.id;


--
-- Name: gadget; Type: TABLE; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

CREATE TABLE gadget (
    id integer NOT NULL,
    name character varying(50),
    description character varying(500),
    pic_url character varying(255)
);


ALTER TABLE gadget OWNER TO irznfnkrlxvtzj;

--
-- Name: gadget_id_seq; Type: SEQUENCE; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

CREATE SEQUENCE gadget_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE gadget_id_seq OWNER TO irznfnkrlxvtzj;

--
-- Name: gadget_id_seq; Type: SEQUENCE OWNED BY; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER SEQUENCE gadget_id_seq OWNED BY gadget.id;


--
-- Name: gadget_suggestion; Type: TABLE; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

CREATE TABLE gadget_suggestion (
    id integer NOT NULL,
    body_part_id integer,
    mobility_score_id integer,
    gadget_id integer
);


ALTER TABLE gadget_suggestion OWNER TO irznfnkrlxvtzj;

--
-- Name: gadget_suggestion_id_seq; Type: SEQUENCE; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

CREATE SEQUENCE gadget_suggestion_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE gadget_suggestion_id_seq OWNER TO irznfnkrlxvtzj;

--
-- Name: gadget_suggestion_id_seq; Type: SEQUENCE OWNED BY; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER SEQUENCE gadget_suggestion_id_seq OWNED BY gadget_suggestion.id;


--
-- Name: gadget_video; Type: TABLE; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

CREATE TABLE gadget_video (
    id integer NOT NULL,
    gadget_id integer,
    video_id integer
);


ALTER TABLE gadget_video OWNER TO irznfnkrlxvtzj;

--
-- Name: gadget_video_id_seq; Type: SEQUENCE; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

CREATE SEQUENCE gadget_video_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE gadget_video_id_seq OWNER TO irznfnkrlxvtzj;

--
-- Name: gadget_video_id_seq; Type: SEQUENCE OWNED BY; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER SEQUENCE gadget_video_id_seq OWNED BY gadget_video.id;


--
-- Name: mobility_score; Type: TABLE; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

CREATE TABLE mobility_score (
    id integer NOT NULL,
    scale character varying(10)
);


ALTER TABLE mobility_score OWNER TO irznfnkrlxvtzj;

--
-- Name: video; Type: TABLE; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

CREATE TABLE video (
    id integer NOT NULL,
    youtube_id character varying(255),
    video_blurb character varying(800),
    gamer_name character varying(50)
);


ALTER TABLE video OWNER TO irznfnkrlxvtzj;

--
-- Name: video_id_seq; Type: SEQUENCE; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

CREATE SEQUENCE video_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE video_id_seq OWNER TO irznfnkrlxvtzj;

--
-- Name: video_id_seq; Type: SEQUENCE OWNED BY; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER SEQUENCE video_id_seq OWNED BY video.id;


--
-- Name: body_part id; Type: DEFAULT; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER TABLE ONLY body_part ALTER COLUMN id SET DEFAULT nextval('body_part_id_seq'::regclass);


--
-- Name: gadget id; Type: DEFAULT; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER TABLE ONLY gadget ALTER COLUMN id SET DEFAULT nextval('gadget_id_seq'::regclass);


--
-- Name: gadget_suggestion id; Type: DEFAULT; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER TABLE ONLY gadget_suggestion ALTER COLUMN id SET DEFAULT nextval('gadget_suggestion_id_seq'::regclass);


--
-- Name: gadget_video id; Type: DEFAULT; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER TABLE ONLY gadget_video ALTER COLUMN id SET DEFAULT nextval('gadget_video_id_seq'::regclass);


--
-- Name: video id; Type: DEFAULT; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER TABLE ONLY video ALTER COLUMN id SET DEFAULT nextval('video_id_seq'::regclass);


--
-- Data for Name: body_part; Type: TABLE DATA; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

COPY body_part (id, name) FROM stdin;
8	Left hand fingers
9	Right hand
10	Right hand thumb
12	Left forearm
13	Right forearm
14	Left upper arm
15	Right upper arm
16	Left leg
17	Right leg
18	Left foot
1	Eyebrows
2	Eyes
3	Speech
4	Mouth
5	Neck
19	Right foot
11	Right hand fingers
6	Left hand
7	Left hand thumb
\.


--
-- Name: body_part_id_seq; Type: SEQUENCE SET; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

SELECT pg_catalog.setval('body_part_id_seq', 26, true);


--
-- Data for Name: gadget; Type: TABLE DATA; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

COPY gadget (id, name, description, pic_url) FROM stdin;
1	Eyegaze	Eye gaze systems allow you to navigate and control your computer by tracking where you are looking. There are a variety of eye gaze cameras to help every individual find the most effective solution.	https://thinksmartbox.com/wp/wp-content/uploads/2015/07/Alea-Intelligaze_transparent_800-630x420.png
2	Grid Pad Go	Small, thin and lightweight, the Grid Pad Go provides the perfect solution for people using touch or switch access on a portable device.	https://thinksmartbox.com/wp/wp-content/uploads/2015/10/Grid-Pad-Go-8-and-10-with-speaker.png
3	Grid Pad Pro	A powerful device that is packed full of features, the Grid Pad Pro includes high-quality audio, multiple access options and our Servus environment control.	https://thinksmartbox.com/wp/wp-content/uploads/2016/05/Grid-Pad-Pro-Group-640x360.png
4	Grid Pad Eye	Including all the features of the Pro model but with integrated eye gaze access. The Grid Pad Eye is available with a wide range of cameras to suit individual need.	https://thinksmartbox.com/wp/wp-content/uploads/2016/05/Grid-Pad-Eye-group-640x360.png
5	Switch Access Pod for Playstation 3	The Game Access by LEPMIS PlayStation3 Switch Access Pod (PS3-SAP) replaces the standard controller of the SONY™ Playstation3 (or other games consoles by adding a cross-converter device) to enable gamers of all physical ability to use accessible switches and joysticks to enjoy a huge choice of video games plus subscription film, music and social media.	http://www.lepmis.co.uk/wp-content/uploads/2015/09/PS3-SAP-new-logo-1024x1024.jpg
6	Heavy Duty Foot Switch	This unit is ideal for people who have good control of their feet and ankles, but can also be used by younger gamers who need to use a whole leg movement to activate a switch. This switch has quite a strong return spring and so can support the weight of a small persons foot and leg.	http://www.lepmis.co.uk/wp-content/uploads/2015/09/FSX-650x650.jpg
7	Medium Duty Foot Switch	This metal foot switch is ideal for positioning under your foot. It will take the weight of your foot and leg resting on the pivot point, and then only a slight flex of your ankle will operate the switch.	http://www.lepmis.co.uk/wp-content/uploads/2015/09/foot-switch-robut-1024x1024.jpg
8	One Handed Game Controller	This PC Game Controller version of the ORTHROS one handed handset provides access to 16 buttons and two analogue joysticks, all accessible by just one hand.	http://www.lepmis.co.uk/wp-content/uploads/2015/09/Screen-Shot-2016-07-05-at-15.51.38.png
9	Switch Arcade Joystick	Each microswitch is terminated with a 3.5mm jack plug on a 0.5m cable. The joystick can be set to activate either one or two microswitches at the same time for four or eight direction output depending upon assembly.	http://www.lepmis.co.uk/wp-content/uploads/2015/09/SAP-JAS-1-1024x1024.jpg
10	Switch Button Joystick	Standard Specs switch from Inclusive Technology. Available in different colours to allow customisation.	http://www.lepmis.co.uk/wp-content/uploads/2015/09/switch-1024x1024.jpg
\.


--
-- Name: gadget_id_seq; Type: SEQUENCE SET; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

SELECT pg_catalog.setval('gadget_id_seq', 10, true);


--
-- Data for Name: gadget_suggestion; Type: TABLE DATA; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

COPY gadget_suggestion (id, body_part_id, mobility_score_id, gadget_id) FROM stdin;
1	1	1	1
2	1	2	1
3	1	1	4
4	1	2	4
5	2	1	1
6	2	2	1
7	2	1	4
8	2	2	4
9	3	1	1
10	3	2	1
11	3	1	4
12	3	2	4
13	4	1	1
14	4	2	1
15	4	1	4
16	4	2	4
17	5	1	1
18	5	2	1
19	5	1	4
20	5	2	4
21	6	1	1
22	6	2	1
23	6	1	2
24	6	2	2
25	6	1	8
26	6	2	8
27	6	1	5
28	6	2	5
29	6	1	9
30	6	2	9
31	7	1	1
32	7	2	1
33	7	1	2
34	7	2	2
35	7	1	8
36	7	2	8
37	7	1	5
38	7	2	5
39	8	1	1
40	8	2	1
41	8	1	2
42	8	2	2
43	8	1	8
44	8	2	8
45	8	1	5
46	8	2	5
47	9	1	1
48	9	2	1
49	9	1	2
50	9	2	2
51	9	1	8
52	9	2	8
53	9	1	5
54	9	2	5
55	9	1	9
56	9	2	9
57	10	1	1
58	10	2	1
59	10	1	2
60	10	2	2
61	10	1	8
62	10	2	8
63	10	1	5
64	10	2	5
65	11	1	1
66	11	2	1
67	11	1	2
68	11	2	2
69	11	1	8
70	11	2	8
71	11	1	5
72	11	2	5
73	12	1	6
74	12	2	6
75	12	1	7
76	12	2	7
77	13	1	6
78	13	2	6
79	13	1	7
80	13	2	7
81	14	1	6
82	14	2	6
83	14	1	7
84	14	2	7
85	15	1	6
86	15	2	6
87	15	1	7
88	15	2	7
89	16	1	9
90	16	2	9
91	16	1	10
92	16	2	10
93	17	1	9
94	17	2	9
95	17	1	10
96	17	2	10
97	18	1	9
98	18	2	9
99	18	1	10
100	18	2	10
101	19	1	9
102	19	2	9
103	19	1	10
104	19	2	10
\.


--
-- Name: gadget_suggestion_id_seq; Type: SEQUENCE SET; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

SELECT pg_catalog.setval('gadget_suggestion_id_seq', 104, true);


--
-- Data for Name: gadget_video; Type: TABLE DATA; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

COPY gadget_video (id, gadget_id, video_id) FROM stdin;
1	5	1
2	10	1
3	1	2
4	10	3
5	5	4
6	10	4
7	1	5
8	4	5
9	1	6
10	4	6
11	10	7
12	9	8
13	10	8
14	1	9
15	4	9
16	10	9
\.


--
-- Name: gadget_video_id_seq; Type: SEQUENCE SET; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

SELECT pg_catalog.setval('gadget_video_id_seq', 16, true);


--
-- Data for Name: mobility_score; Type: TABLE DATA; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

COPY mobility_score (id, scale) FROM stdin;
1	Good
2	Medium
3	Some
\.


--
-- Data for Name: video; Type: TABLE DATA; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

COPY video (id, youtube_id, video_blurb, gamer_name) FROM stdin;
7	XOxPamsC6Oc	Daryl's a hardcore gamer, despite his cerebral palsy. We've been working with him both in our Games Room and at his home to find a way for him to have independent control of his games on an Xbox 360 console.	Daryl
8	Bd2BsLecH9o	Here's six year-old Elliott experiencing the magic of playing on an Xbox together with his friends and family for the first time.	Elliott
9	UvnzC3PhEMg	Holly, who's a bubbly ten year-old with cerebral palsy, is racing cars on her PlayStation with her brother, something she's wanted to do for a very long time. She's controlling the cars through switches built into her headrest, which are normally used to steer her powered wheelchair. The SpecialEffect team have connected them to a PlayStation controller interface, giving her manoeuvres such as left and right steering, accelerate and brake.	Holly
1	QOhJmREwLSo	Ceyda has cerebral palsy and finds using hand controls very difficult. But with this custom gaming setup from the team at SpecialEffect, a UK-based charity that help people with disabilities to enjoy video games, the frustration of having to watch her friends have all the fun is over. Here she is having a ball in Disney Infinity.	Ceyda
2	30QGu0-uctQ	Here's Ajay, an IT support analyst with spinal muscular atrophy, explaining what it means to regain the ability to enjoy video games. He hadn't been able to play since he lost his hand dexterity when was 17 years old, but we introduced him to a chin-controlled joystick and voice control setup that's got him back in the game.	Ajay
3	evkBrzeKnZQ	When Arlo's friends came round, they'd end up playing outside with his brother. Not any more. After our visit he's now overcoming his disabilities and practicing to take on his mates - and he means to win!	Arlo
4	5uhsUKFDiso	Take a look at the short video below. It's about Ben, who never thought he'd be able to play video games because of his spinal muscular atrophy.  “I’ve never played a proper computer game,” he said. “I’ve always watched my friends play. Games are important to me because I can’t go out and play football like other kids so I do it on a computer screen.” We bluetoothed Ben's wheelchair joystick to a laptop so it could act as the left gaming stick for games like FIFA and Grand Turismo. We also rigged up a selection of light-touch switches for his fingers and connected them to the PlayStation via a couple of interfaces.	Ben
5	ejPzD3o8aOs	Callum suffered a spinal injury as a result of a BMX accident, which left him paralysed from the shoulders down.\n\nUnable to use his hands, he'd given up the hope of ever being able to play on his Playstation with his friends and family again. But his occupational therapist at Stoke Mandeville Spinal Unit introduced SpecialEffect to him, and our team were able to make home visits to try out some controller setups which would allow him to play games using his chin.	Callum
6	VMlbomJZFSg	Chloe and Ella, two girls with very different disabilities, having a fantastic time in our GamesRoom discovering which computer games they can play. And, most importantly, which ones they can play together. This video shows them discovering the fun of Once Upon a Monster and Just Dance on the Kinect. The two girls are now firm friends and have regular computer and video game play dates.	Chloe and Ella
\.


--
-- Name: video_id_seq; Type: SEQUENCE SET; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

SELECT pg_catalog.setval('video_id_seq', 9, true);


--
-- Name: body_part body_part_pkey; Type: CONSTRAINT; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER TABLE ONLY body_part
    ADD CONSTRAINT body_part_pkey PRIMARY KEY (id);


--
-- Name: gadget gadget_pkey; Type: CONSTRAINT; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER TABLE ONLY gadget
    ADD CONSTRAINT gadget_pkey PRIMARY KEY (id);


--
-- Name: gadget_suggestion gadget_suggestion_pkey; Type: CONSTRAINT; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER TABLE ONLY gadget_suggestion
    ADD CONSTRAINT gadget_suggestion_pkey PRIMARY KEY (id);


--
-- Name: gadget_video gadget_video_pkey; Type: CONSTRAINT; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER TABLE ONLY gadget_video
    ADD CONSTRAINT gadget_video_pkey PRIMARY KEY (id);


--
-- Name: mobility_score mobility_score_pkey; Type: CONSTRAINT; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER TABLE ONLY mobility_score
    ADD CONSTRAINT mobility_score_pkey PRIMARY KEY (id);


--
-- Name: video video_pkey; Type: CONSTRAINT; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER TABLE ONLY video
    ADD CONSTRAINT video_pkey PRIMARY KEY (id);


--
-- Name: gadget_suggestion gadget_suggestion_body_part_id_fkey; Type: FK CONSTRAINT; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER TABLE ONLY gadget_suggestion
    ADD CONSTRAINT gadget_suggestion_body_part_id_fkey FOREIGN KEY (body_part_id) REFERENCES body_part(id);


--
-- Name: gadget_suggestion gadget_suggestion_gadget_id_fkey; Type: FK CONSTRAINT; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER TABLE ONLY gadget_suggestion
    ADD CONSTRAINT gadget_suggestion_gadget_id_fkey FOREIGN KEY (gadget_id) REFERENCES gadget(id);


--
-- Name: gadget_suggestion gadget_suggestion_mobility_score_id_fkey; Type: FK CONSTRAINT; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER TABLE ONLY gadget_suggestion
    ADD CONSTRAINT gadget_suggestion_mobility_score_id_fkey FOREIGN KEY (mobility_score_id) REFERENCES mobility_score(id);


--
-- Name: gadget_video gadget_video_gadget_id_fkey; Type: FK CONSTRAINT; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER TABLE ONLY gadget_video
    ADD CONSTRAINT gadget_video_gadget_id_fkey FOREIGN KEY (gadget_id) REFERENCES gadget(id);


--
-- Name: gadget_video gadget_video_video_id_fkey; Type: FK CONSTRAINT; Schema: hackers2017; Owner: irznfnkrlxvtzj
--

ALTER TABLE ONLY gadget_video
    ADD CONSTRAINT gadget_video_video_id_fkey FOREIGN KEY (video_id) REFERENCES video(id);


--
-- PostgreSQL database dump complete
--

