'''
Streamlit 라이브러리를 이용한 삼성전자 주식 차트를 표시하는 웹앱입니다.
'''

import streamlit as st
import pandas_datareader as pdr

st.write('''
# 삼성전자 주식 데이터
마감 가격과 거래량을 차트로 보여줍니다!
''')

# https://finance.yahoo.com/quote/005930.KS?p=005930.KS
df = pdr.get_data_yahoo('005930.KS', '2020-01-01', '2020-09-30')

st.line_chart(df.Close)
st.line_chart(df.Volume)