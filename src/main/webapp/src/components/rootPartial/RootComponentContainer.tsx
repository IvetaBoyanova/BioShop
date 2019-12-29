import React from 'react';
import { findDOMNode } from 'react-dom'
import { connect } from "react-redux";
import { createSelector } from "reselect";
// import { getAddedIdsLen, getCartProducts } from '../../reducers'
import RootComponent from '../../components/RootComponent'

interface PassedProps extends React.Props<any> {
   children: any
}

class RootContainer extends React.Component<React.Props<any> & PassedProps, any> {
   cartButton: any;

   constructor() {
      super(null);
      this.state = {
         mobileDrawerOpen: false,
         topBarPop: false,
         winWidth: window.innerWidth,
         topBarPopAnchorEl: null
      };
      this.handleWinWidth = this.handleWinWidth.bind(this);
   }
   componentDidMount() {
      window.addEventListener('resize', this.handleWinWidth)
   }
   componentWillUnmount() {
      window.removeEventListener('resize', this.handleWinWidth)
   }
   handleWinWidth = () => this.setState({ winWidth: window.innerWidth });
   handleDrawer = () => this.setState({ mobileDrawerOpen: !(this.state as any).mobileDrawerOpen });
   handlePopOver = () => this.setState({ topBarPop: !(this.state as any).topBarPop, topBarPopAnchorEl: findDOMNode(this.cartButton) });
   handleClickMenu = id => {
      (this.props.children as any).props.history.push('/cart')
   };

   render() {
      const { children, cartProducts } = (this.props as any);
      return (
         <RootComponent
            cartProducts={cartProducts}
            menuIconCounter={(this.state as any).winWidth}
            children={children}
            mobileDrawerOpen={(this.state as any).mobileDrawerOpen}
            handleDrawer={this.handleDrawer}
            handlePopOver={this.handlePopOver}
            PopOverOpen={(this.state as any).topBarPop}
            AnchorEl={(this.state as any).topBarPopAnchorEl}
            cartBtn={this.cartButton}
            handleClickMenu={this.handleClickMenu}
         />
      )
   }
}

const cartItemsCount = state => 0; //getAddedIdsLen(state)
const cartProducts = state => 0; //getCartProducts(state)
const cartMemoizedSelector = createSelector(
   cartItemsCount, cartProducts,
   (cartItemsCount, cartProducts) => ({ cartItemsCount: cartItemsCount, cartProducts: cartProducts })
);

const mapStateToProps = (state) => ({
   cartItemsCount: cartMemoizedSelector(state),
   cartProducts: cartMemoizedSelector(state)
});
export default connect<{}, {}, PassedProps>(mapStateToProps)(RootContainer)