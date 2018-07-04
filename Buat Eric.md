# AndroidGsonParser

Problem #1

Di baris #71 (MainActivity.java) onClick URL buat nge-parsing JSON-nya, gak bisa disambung ke volley. 
Pengennya, narik keluar hasil URL-nya dari onClick biar bisa diteruskan sama Volley buat di-fetch JSON-nya.

Problem #2

Nge-parsing JSON-nya Nested Array yang kayak gini:

{
  "items": [
    {
      "tags": [
        "android",
        "xml",
        "mvvm",
        "data-binding",
        "viewmodel"
      ],
      "owner": {
        "reputation": 40,
        "user_id": 9543418,
        "user_type": "registered",
        "profile_image": "https://graph.facebook.com/1337079696386146/picture?type=large",
        "display_name": "Muhammed Haris",
        "link": "https://stackoverflow.com/users/9543418/muhammed-haris"
      },
      "is_answered": true,
      "view_count": 13,
      "answer_count": 2,
      "score": 0,
      "last_activity_date": 1530700364,
      "creation_date": 1530699543,
      "last_edit_date": 1530700364,
      "question_id": 51171317,
      "link": "https://stackoverflow.com/questions/51171317/how-to-use-ternary-condition-inside-a-ternaroy-operator-in-xml-while-setting-dat",
      "title": "How to use Ternary condition inside a Ternaroy Operator in xml while setting data to a TextView withh android databinding"
    }
  ],
  "has_more": true,
  "quota_max": 10000,
  "quota_remaining": 9988
}

Kan ada setelah array "items", ada 2 array lagi, nah itu dia yang dari kemaren aku usaha buat nge-parsing-nya gimana. pakai GSON?

Tolong bantuannya ya bro Eric. I will forever indebt with you!
