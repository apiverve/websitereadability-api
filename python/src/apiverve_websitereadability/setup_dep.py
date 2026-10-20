from setuptools import setup, find_packages

setup(
    name='apiverve_websitereadability',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Website Readability analyzes live web pages to score their reading difficulty and educational grade level. It returns Flesch Reading Ease, Flesch-Kincaid grade level, word count, sentence count, and estimated reading time.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/websitereadability?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
