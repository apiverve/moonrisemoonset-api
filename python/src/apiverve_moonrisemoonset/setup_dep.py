from setuptools import setup, find_packages

setup(
    name='apiverve_moonrisemoonset',
    version='1.2.3',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Moonrise Moonset calculates exact moonrise and moonset times for any geographic coordinate. It outputs ISO 8601 timestamps for lunar rise and set events, with paid plans adding moon phase details and date selection.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/moonrisemoonset?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
