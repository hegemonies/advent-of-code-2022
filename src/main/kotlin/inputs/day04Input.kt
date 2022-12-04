package inputs

val day04Input = """
    2-9,9-51
    33-51,45-73
    28-29,29-93
    37-47,37-48
    7-71,2-71
    18-20,19-54
    9-92,9-51
    23-83,82-83
    28-86,27-28
    43-43,42-78
    10-79,9-11
    19-97,19-74
    29-54,50-53
    15-94,20-93
    11-12,14-70
    8-96,8-8
    7-90,90-90
    32-59,32-60
    33-56,55-63
    53-77,34-52
    3-60,5-23
    76-95,93-95
    17-76,16-77
    50-64,25-49
    31-64,64-79
    71-91,71-72
    47-49,48-83
    1-99,2-99
    89-94,86-99
    52-79,79-79
    6-88,10-24
    16-53,17-53
    1-96,96-97
    10-11,11-43
    66-89,4-85
    69-70,33-70
    30-43,29-31
    4-50,9-51
    22-81,9-61
    7-80,79-98
    77-78,40-78
    36-99,36-98
    4-13,13-79
    90-98,14-93
    71-98,4-62
    74-87,73-87
    46-86,84-97
    1-57,36-58
    82-96,9-83
    27-96,2-96
    33-33,33-33
    93-94,45-94
    92-92,4-93
    3-70,1-77
    53-94,72-86
    84-85,39-85
    10-74,10-88
    59-95,72-83
    37-75,23-85
    17-19,10-19
    1-83,1-82
    2-93,94-94
    26-84,83-84
    35-57,34-58
    16-74,17-17
    38-88,38-89
    70-96,69-96
    43-76,77-88
    2-99,2-87
    33-56,74-81
    19-50,19-20
    26-94,94-97
    5-78,2-82
    27-77,26-77
    47-98,45-99
    6-89,5-5
    35-56,22-57
    3-96,1-3
    97-97,24-96
    4-35,5-68
    3-5,34-85
    89-90,82-91
    6-46,6-65
    17-34,17-35
    10-82,11-81
    4-53,2-4
    21-88,21-75
    67-99,22-68
    3-89,90-94
    4-97,2-98
    2-69,2-3
    41-62,42-61
    39-88,10-90
    3-43,18-42
    3-83,28-84
    74-87,22-86
    35-98,35-99
    11-92,10-10
    8-15,9-17
    10-17,55-94
    54-74,53-60
    3-96,3-4
    5-18,5-70
    6-88,3-3
    98-98,5-99
    60-87,59-84
    28-76,27-77
    17-26,26-70
    4-6,3-5
    83-99,83-97
    10-65,65-69
    6-73,2-74
    44-96,44-95
    89-89,10-88
    2-91,95-96
    13-60,12-59
    6-29,5-27
    57-57,12-58
    48-85,48-85
    97-98,20-85
    62-97,99-99
    3-6,8-99
    20-34,12-14
    18-84,17-85
    5-88,4-46
    63-67,32-64
    52-80,52-80
    35-97,3-9
    35-78,35-79
    42-65,66-66
    30-30,30-93
    35-44,36-41
    26-95,4-92
    5-5,5-30
    15-88,16-87
    14-54,55-55
    8-41,41-57
    11-93,20-84
    7-61,6-7
    16-37,37-89
    36-89,35-90
    9-39,9-40
    79-92,72-80
    39-97,97-98
    75-81,21-76
    3-70,71-71
    2-94,2-94
    4-5,5-80
    2-84,2-84
    44-57,45-56
    36-76,3-77
    48-54,53-98
    14-71,3-71
    18-98,2-98
    29-85,14-30
    5-88,4-6
    54-84,22-53
    11-75,61-79
    73-74,39-73
    61-98,61-62
    1-4,5-59
    66-94,88-94
    32-38,38-64
    4-59,1-5
    25-57,24-36
    45-69,46-68
    53-77,53-63
    1-94,4-93
    17-89,88-90
    9-90,21-39
    9-90,8-15
    65-82,66-81
    7-83,7-83
    24-98,24-77
    1-1,3-99
    16-18,17-47
    31-87,32-88
    96-98,34-95
    32-67,31-67
    16-58,57-57
    37-83,24-40
    4-66,3-66
    36-74,44-73
    22-81,22-23
    2-7,7-61
    20-21,21-76
    74-74,7-73
    12-46,4-11
    95-99,16-96
    38-80,39-39
    1-19,7-65
    39-53,39-84
    24-82,23-28
    43-44,43-92
    48-60,49-94
    66-85,31-65
    30-31,30-64
    56-95,36-55
    68-93,58-68
    47-59,46-46
    12-33,32-97
    57-75,62-84
    7-8,12-93
    42-75,76-76
    33-81,34-80
    4-5,4-97
    56-78,23-95
    53-53,54-67
    6-46,10-77
    55-87,87-88
    63-83,63-63
    1-1,1-43
    80-92,49-92
    95-99,11-95
    31-34,36-46
    25-83,84-96
    2-98,3-98
    1-3,2-69
    83-97,52-97
    35-93,37-78
    15-44,45-45
    1-99,2-99
    65-89,8-95
    23-59,28-60
    94-94,18-93
    3-44,12-90
    14-51,5-51
    13-38,12-14
    50-88,49-89
    46-69,47-47
    38-44,44-53
    11-73,87-88
    3-58,2-3
    42-89,90-98
    5-41,6-36
    48-90,47-49
    14-50,14-50
    16-24,3-16
    40-41,40-48
    37-37,1-38
    6-38,26-38
    8-96,17-95
    13-98,99-99
    2-57,3-56
    3-30,1-37
    4-68,4-67
    17-20,21-90
    13-17,16-23
    24-25,25-92
    2-2,1-96
    19-91,90-93
    6-79,7-50
    27-28,22-28
    12-98,9-98
    1-4,3-71
    10-20,19-51
    15-15,15-66
    95-95,30-96
    1-93,3-90
    41-43,42-86
    77-93,76-77
    87-99,96-99
    1-99,98-98
    13-70,2-64
    66-84,51-67
    24-89,43-92
    3-43,2-4
    46-48,47-82
    6-96,1-5
    13-76,13-76
    1-83,84-96
    42-60,3-21
    10-49,5-16
    42-95,96-97
    35-35,32-34
    5-7,6-27
    6-16,30-46
    98-99,14-97
    23-75,22-24
    16-18,17-90
    72-73,57-71
    13-78,10-98
    57-62,58-66
    22-57,58-58
    2-75,5-72
    7-24,11-66
    37-91,68-90
    57-94,6-93
    57-67,57-68
    6-18,17-85
    10-10,11-73
    19-35,34-34
    13-30,29-71
    78-78,68-79
    40-54,40-40
    14-60,13-60
    6-31,31-94
    25-76,55-75
    76-81,47-81
    34-58,43-57
    16-60,15-17
    95-97,9-96
    6-7,7-87
    99-99,3-98
    13-36,28-69
    13-26,12-26
    17-57,56-58
    20-95,27-44
    81-88,81-88
    29-45,28-45
    71-77,71-78
    4-17,28-82
    75-77,12-76
    40-44,39-41
    60-90,89-89
    28-43,28-48
    8-89,74-90
    1-4,6-77
    7-74,75-75
    84-94,6-93
    94-95,21-95
    10-63,64-87
    23-97,25-83
    11-68,11-74
    41-45,40-44
    30-88,83-87
    26-74,67-68
    2-6,7-60
    41-41,31-37
    91-91,20-90
    8-8,7-77
    66-77,74-77
    89-97,92-99
    63-70,64-70
    95-98,3-96
    14-79,78-78
    58-81,80-92
    59-94,58-58
    12-23,13-83
    9-85,9-9
    13-97,9-92
    56-73,16-57
    2-96,99-99
    31-73,30-41
    17-91,18-90
    74-94,64-75
    8-97,1-4
    6-95,5-6
    94-97,38-95
    9-80,53-69
    8-8,8-70
    11-94,11-93
    38-86,87-93
    7-85,6-7
    3-90,1-98
    18-88,14-73
    7-95,8-94
    27-77,7-26
    55-98,55-56
    49-90,85-91
    14-64,14-37
    91-95,8-92
    48-94,10-48
    95-96,68-95
    84-98,82-84
    69-69,13-68
    23-93,11-24
    8-25,25-30
    15-79,14-16
    2-98,1-97
    60-70,59-70
    11-69,68-74
    56-83,32-82
    18-97,18-97
    30-72,57-71
    10-55,14-69
    9-9,9-96
    20-92,6-19
    17-47,19-73
    51-86,85-85
    94-94,3-95
    1-99,99-99
    19-22,18-22
    51-76,50-52
    99-99,19-98
    95-95,24-46
    35-81,36-66
    25-86,29-87
    6-50,4-94
    12-35,56-70
    15-69,70-70
    6-95,96-97
    84-97,75-96
    10-10,10-10
    2-22,13-23
    43-90,91-91
    2-95,1-3
    25-65,25-25
    3-57,3-21
    50-64,38-50
    9-94,93-96
    6-49,7-48
    69-82,73-83
    74-95,71-95
    8-95,9-94
    36-78,37-77
    29-31,30-86
    7-78,26-77
    66-66,38-67
    43-86,44-92
    29-31,30-84
    15-59,58-84
    1-1,3-98
    14-33,20-34
    80-80,45-79
    35-95,23-73
    14-16,15-56
    3-56,1-57
    5-98,98-98
    80-93,13-90
    49-96,95-98
    2-85,1-84
    36-43,35-79
    4-99,2-99
    29-94,29-94
    1-95,96-96
    42-47,43-91
    35-98,31-39
    48-71,14-36
    10-70,71-99
    3-3,3-52
    89-89,58-88
    2-91,1-92
    60-82,40-61
    49-50,49-91
    97-97,1-94
    9-9,9-45
    1-1,3-40
    1-99,8-98
    61-63,60-63
    11-38,38-59
    8-54,3-5
    72-80,72-79
    30-97,30-96
    1-99,2-99
    14-62,49-61
    15-28,14-54
    20-27,27-87
    5-55,5-97
    1-94,69-94
    95-98,16-96
    62-62,61-76
    2-10,4-53
    8-73,7-73
    4-87,94-97
    10-82,10-84
    11-77,77-78
    6-98,6-6
    44-63,44-52
    58-90,57-58
    15-79,16-79
    3-8,4-72
    7-17,8-49
    19-87,18-20
    94-94,14-95
    47-65,66-66
    82-97,82-82
    2-11,6-12
    34-36,18-73
    1-30,27-31
    5-97,4-91
    33-83,9-33
    21-73,72-74
    9-75,8-89
    3-6,5-93
    3-77,1-4
    4-31,8-92
    42-50,41-51
    72-89,60-85
    86-89,14-85
    13-72,12-72
    67-79,37-79
    97-99,9-97
    9-50,8-88
    44-65,44-44
    47-78,79-91
    24-64,12-32
    8-83,9-82
    18-85,5-86
    4-69,5-70
    5-91,7-98
    17-19,4-19
    80-80,1-81
    1-95,4-94
    1-69,4-34
    58-59,58-62
    83-95,30-84
    2-30,3-91
    11-30,29-61
    5-94,8-93
    8-12,12-96
    78-95,36-79
    15-87,83-88
    84-84,84-84
    8-10,9-81
    79-98,26-98
    2-2,2-94
    62-78,46-62
    2-79,1-3
    73-75,3-73
    52-54,35-53
    46-81,4-82
    9-96,9-9
    68-98,97-99
    29-74,6-30
    31-31,32-67
    2-97,1-3
    43-47,17-44
    31-75,69-86
    60-72,23-71
    10-67,10-68
    61-63,4-62
    26-65,50-65
    9-29,35-88
    14-78,15-78
    4-76,77-90
    32-33,64-78
    52-92,53-97
    29-47,24-45
    52-70,53-69
    96-96,15-97
    52-89,46-89
    3-5,6-84
    12-75,12-81
    46-57,28-46
    53-76,14-57
    18-52,52-89
    33-53,71-92
    12-28,29-67
    3-7,4-52
    50-55,55-66
    63-63,63-92
    12-86,12-86
    44-57,43-44
    2-61,3-61
    56-85,1-57
    4-6,6-98
    1-75,56-75
    58-60,59-59
    4-22,15-23
    4-17,2-4
    1-33,2-32
    10-89,20-90
    8-72,2-73
    10-69,10-45
    65-80,50-80
    22-94,22-75
    24-98,24-99
    23-99,26-98
    6-71,1-83
    4-5,4-97
    5-25,14-43
    23-74,22-87
    89-96,97-99
    41-46,26-45
    20-86,20-95
    9-97,9-96
    74-77,30-82
    56-68,58-69
    7-10,7-94
    2-87,87-93
    49-92,72-91
    13-14,13-72
    37-38,37-39
    56-74,7-73
    17-95,51-99
    10-95,10-10
    1-97,96-98
    23-53,27-69
    29-65,29-58
    32-89,31-32
    25-43,25-26
    60-61,61-91
    87-89,33-88
    35-35,35-37
    11-47,39-62
    50-52,28-51
    65-65,20-64
    34-91,40-59
    10-67,99-99
    5-82,4-6
    11-40,11-11
    17-57,1-18
    21-22,21-93
    6-79,6-7
    1-75,75-92
    3-82,4-70
    29-58,29-82
    33-33,33-62
    25-33,24-25
    8-80,9-9
    45-69,44-64
    13-17,17-37
    2-97,2-98
    13-88,12-14
    3-61,16-69
    4-95,1-2
    43-45,44-81
    24-71,70-70
    55-92,91-97
    93-98,20-92
    51-52,36-52
    1-97,20-98
    1-86,1-86
    41-85,86-97
    26-28,26-29
    11-38,10-39
    32-70,31-31
    29-31,30-86
    68-94,84-94
    14-19,19-71
    39-94,94-97
    20-41,40-51
    3-88,89-98
    65-86,79-85
    38-99,38-39
    64-75,64-65
    90-92,6-91
    4-30,6-29
    3-47,2-48
    72-85,71-81
    64-70,65-65
    26-95,4-26
    7-13,13-91
    13-81,26-80
    7-67,1-7
    41-58,58-81
    2-96,2-83
    80-89,6-88
    3-41,40-88
    36-46,47-85
    43-81,42-42
    50-50,50-93
    79-91,8-74
    17-24,19-49
    63-80,71-80
    37-91,90-95
    48-90,47-51
    22-79,22-23
    35-57,67-89
    31-54,8-91
    44-68,52-90
    7-75,74-90
    50-64,49-49
    1-1,3-98
    9-98,10-98
    59-91,14-92
    28-93,21-27
    11-81,4-92
    14-21,38-57
    56-90,57-71
    16-67,16-67
    23-56,8-55
    9-47,25-96
    69-96,64-84
    73-78,72-74
    5-48,42-59
    18-53,4-19
    9-23,2-23
    90-92,42-91
    11-39,12-81
    1-93,1-92
    94-98,26-95
    2-10,10-69
    94-94,43-93
    51-97,50-52
    14-35,3-15
    26-26,26-26
    1-96,1-2
    22-84,21-23
    5-82,18-99
    27-37,27-44
    9-10,9-92
    43-88,1-87
    74-74,53-75
    26-96,20-93
    26-70,27-29
    56-60,55-55
    5-89,2-89
    36-88,36-88
    80-80,26-80
    3-3,4-91
    13-18,17-96
    14-43,9-44
    41-69,70-70
    7-93,7-88
    50-51,50-93
    62-62,62-62
    2-93,87-99
    69-98,99-99
    23-24,23-50
    34-65,34-80
    12-25,11-26
    87-88,87-87
    87-91,28-88
    31-33,32-93
    25-38,26-73
    88-97,58-89
    6-96,5-7
    8-56,7-30
    40-91,92-92
    22-24,37-94
    77-83,84-84
    67-67,34-68
    17-19,18-93
    74-97,4-96
    9-87,88-88
    47-48,47-99
    69-69,69-92
    29-68,29-38
    27-29,28-92
    66-78,12-63
    79-82,78-87
    62-67,7-68
    16-92,17-91
    34-79,80-94
    8-36,20-97
    62-77,61-61
    74-81,81-90
    88-90,2-89
    68-91,67-92
    21-24,25-87
    9-63,8-64
    61-79,25-60
    24-51,52-52
    3-89,97-97
    30-94,16-98
    12-74,9-86
    11-91,12-90
    2-4,5-14
    7-91,52-97
    10-58,7-11
    27-66,26-28
    54-81,9-82
    14-59,13-59
    62-62,53-61
    7-15,8-22
    2-8,1-73
    20-65,20-65
    52-52,53-53
    76-85,76-86
    5-11,5-5
    10-72,72-79
    23-92,24-92
    66-97,48-65
    2-69,97-98
    4-51,51-89
    11-95,12-95
    79-98,68-79
    14-22,21-87
    11-53,10-52
    1-74,73-75
    88-92,87-87
    4-91,3-5
    35-91,14-85
    58-91,58-90
    30-30,29-30
    14-49,6-50
    29-78,29-79
    33-62,25-32
    15-92,15-97
    63-70,13-70
    16-81,17-81
    77-77,25-76
    10-72,10-71
    4-79,2-5
    15-21,15-46
    41-58,26-57
    10-62,63-87
    12-24,24-71
    5-58,59-59
    11-15,10-10
    44-61,43-47
    74-74,7-73
    3-85,86-93
    29-56,30-55
    33-40,25-39
    37-69,69-80
    25-89,12-88
    6-99,5-6
    8-10,9-73
    31-47,46-80
    57-57,3-56
    65-65,13-66
    3-85,1-97
    78-92,40-77
    45-64,38-63
    12-13,13-99
    84-92,83-91
    73-91,74-74
    23-55,2-24
    16-52,15-53
    12-29,29-78
    96-98,12-96
    82-89,88-88
    59-78,50-64
    9-9,9-63
    15-47,14-16
    42-72,20-65
    41-92,13-93
    78-85,70-79
    25-53,20-24
    62-96,61-63
    50-57,49-58
    14-93,14-95
    3-10,2-10
    84-84,77-83
    1-99,1-2
    50-90,36-91
    95-95,6-94
    29-38,29-49
    31-89,31-31
    5-81,4-76
    47-74,58-73
    69-90,68-68
    15-80,12-16
    53-85,84-86
    18-24,19-25
    14-16,15-88
    13-90,2-97
    90-91,90-90
    52-54,17-53
    50-59,43-52
    21-59,54-60
    64-84,64-82
    64-64,38-63
    43-75,69-73
    30-56,55-57
    46-63,39-46
    3-96,96-96
    1-97,15-93
    20-62,20-20
    65-90,64-79
    94-94,12-93
    45-53,13-46
    21-89,22-88
    18-31,32-38
    48-68,47-70
    29-92,30-91
    20-58,20-20
    66-66,66-95
    39-67,24-40
    8-95,4-96
    27-75,65-85
    1-94,93-93
    77-93,92-97
    53-54,52-55
    37-62,36-37
    7-11,6-61
    34-62,35-61
    54-56,55-57
    60-60,61-73
    48-66,64-76
    59-73,38-60
    3-8,3-97
    93-93,79-92
    4-40,39-40
    80-87,8-81
    7-22,21-88
    2-97,13-99
    33-99,32-81
    45-82,23-82
    34-91,34-35
    76-81,50-80
    9-76,76-97
    33-90,33-33
    32-59,31-59
    1-91,3-90
    60-97,96-99
    89-89,3-90
    10-36,6-11
    41-92,48-90
    26-87,70-88
    73-74,74-86
    16-77,15-16
    4-95,1-4
    77-93,76-98
    74-75,45-75
    8-60,8-56
    4-98,2-31
    16-87,86-98
    25-73,72-74
    27-88,26-89
    13-35,11-60
    75-75,71-76
    56-96,95-97
    14-86,15-39
    15-35,16-35
    78-78,29-77
    32-92,54-92
    3-32,31-67
    66-85,66-66
    10-61,9-10
    34-81,35-89
    8-83,98-99
    3-99,3-4
    18-38,19-37
    19-19,19-33
    15-69,14-70
    11-72,11-87
    42-65,40-76
    8-55,16-29
    3-11,10-82
    12-76,14-89
    40-51,12-65
    11-93,11-94
    1-76,1-77
    83-89,48-87
    8-67,7-51
    77-82,77-81
    18-80,19-81
    32-42,43-65
    20-40,16-20
    22-82,22-83
    92-93,45-92
    44-46,45-98
    13-95,13-14
    45-72,46-72
    1-94,37-99
    51-84,12-83
    33-99,34-98
    5-6,5-57
    9-80,8-81
    54-66,44-52
    31-36,14-98
    56-60,57-60
    2-46,47-47
    6-13,16-19
    88-88,14-89
    95-96,20-95
    32-97,70-97
    33-41,33-47
    1-99,2-98
    1-60,55-60
    67-68,52-68
    13-88,3-14
    27-36,41-50
    44-75,75-76
    18-57,56-96
    21-71,22-72
    6-50,5-7
    3-79,2-4
    31-84,56-90
    6-97,9-97
    24-96,23-23
    21-22,21-21
    18-84,3-76
    43-57,44-63
    5-5,3-6
    68-98,57-94
    14-69,15-68
    48-62,48-86
    52-95,75-92
    33-58,32-76
    11-28,7-12
    42-42,42-97
    42-44,43-90
    27-97,98-99
    5-63,5-5
    68-74,59-74
    1-3,4-60
    15-53,6-14
    27-45,26-46
    36-93,15-94
    64-85,40-66
    26-53,43-52
    3-93,2-26
    7-99,11-97
    12-96,13-98
    16-84,7-17
    15-16,15-93
    21-93,45-93
    45-46,46-47
    58-65,57-65
    5-98,38-97
    19-33,25-38
    21-81,16-69
    48-88,75-79
    88-99,64-97
    5-71,2-72
    16-80,15-80
    1-3,2-99
    38-92,37-38
    58-79,45-73
    27-91,27-27
    24-67,22-22
    14-48,13-20
    4-4,3-34
    15-15,14-51
    7-20,6-21
""".trimIndent()
