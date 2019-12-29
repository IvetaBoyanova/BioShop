import React from "react";
import Slideshow from'react-slidez';
import slideOne from '../../images/1.webp';
import slideTwo from '../../images/2.webp';
import slideThree from '../../images/3.webp';
import slideFour from '../../images/4.webp';

const Home = () => (
   <Slideshow
      showIndex
      showArrows
      autoplay
      enableKeyboard
      useDotIndex
      slideInterval={5000}
      defaultIndex={0}
      slides={[slideOne, slideTwo, slideThree, slideFour]}
      effect={'fade'}
      height={'100%'}
      width={'100%'}
   />
);

export default Home;