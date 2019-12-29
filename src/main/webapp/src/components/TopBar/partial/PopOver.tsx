import React from 'react';
import { Popover } from "@material-ui/core";
import withStyles from '@material-ui/core/styles/withStyles';
import MenuList from './MenuList'

const Styles = {
   PopoverPaper: {
      opacity: 1,
      transform: 'scale(1, 1)',
      transition: 'opacity 171ms cubic-bezier(0.4, 0, 0.2, 1) 0ms, transform 114ms cubic - bezier(0.4, 0, 0.2, 1) 0ms',
      top: 64,
      left: 1151,
      transformOrigin: '187px - 26px 0px'
   }
};

const CartPopOver = ({ handlePopOver, PopOverOpen, AnchorEl, classes, cartProducts, handleClickMenu, menuAnchorEl, menuSelectedIndex }) => {
   return (
      <div>
         <Popover
            open={PopOverOpen}
            anchorEl={AnchorEl}
            onClose={handlePopOver}
            anchorOrigin={{
               vertical: 'top',
               horizontal: 'right',
            }}
            transformOrigin={{
               vertical: 'top',
               horizontal: 'right'
            }}
         >
            <MenuList
               handleClickMenu={handleClickMenu}
            />
         </Popover>
      </div>
   )
}
export default withStyles(Styles)(CartPopOver)